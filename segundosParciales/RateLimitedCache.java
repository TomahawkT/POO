package segundosParciales;

import java.util.HashMap;
import java.util.Map;

public class RateLimitedCache<K,V> extends BaseCache<K,V>{
    private final Map<String, QuotaType> quotaTypeMap = new HashMap<>();
    private final Map<String, Map<String, UserData>> readsAndWritesMap = new HashMap<>();

    public void register(String user, QuotaType quotaType){
        quotaTypeMap.put(user, quotaType);
        readsAndWritesMap.put(user, new HashMap<>());
    }

    private QuotaType validateUser(String user) {
        QuotaType quotaType = quotaTypeMap.get(user);
        if(quotaType == null) {
            throw new IllegalArgumentException();
        }
        return quotaType;
    }

    private UserData validateUserData(String user, String date) {
        readsAndWritesMap.get(user).putIfAbsent(date, new UserData());
        return readsAndWritesMap.get(user).get(date);
    }

    @Override
    public void put(String user, String date, K key, V value){
        QuotaType quotaType = validateUser(user);
        UserData userData = validateUserData(user, date);
        if(!quotaType.canWrite(userData.getWrites())) {
            throw new RateLimitedException();
        }
        userData.write();
        super.put(user, date, key, value);

    }

    @Override
    public V get(String user, String date, K key) {
        QuotaType quotaType = validateUser(user);
        UserData userData = validateUserData(user, date);
        if(!quotaType.canRead(userData.getReads())) {
            throw new RateLimitedException();
        }
        userData.read();
        return super.get(user, date, key);
    }

    private static class UserData{
        int reads, writes;

        public int getReads() {
            return reads;
        }

        public int getWrites() {
            return writes;
        }

        public void read(){
            reads++;
        }

        public void write(){
            writes++;
        }
    }
}
