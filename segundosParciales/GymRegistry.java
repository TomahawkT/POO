package segundosParciales;

import java.util.HashMap;
import java.util.Map;

public class GymRegistry {
    private final Map<String, Membership> membershipMap= new HashMap<>();
    private final Map<String,Map<Integer,Integer>> visitsMap = new HashMap<>();

    public void registerClient(String name, Membership membership){
        if(membershipMap.containsKey(name)){
            throw new GymRegistryException(String.format("%s already exists", name));
        }
        membershipMap.put(name, membership);
        visitsMap.put(name, new HashMap<>());
    }

    public boolean canVisit(String name, int month){
        checkClient(name);
        return membershipMap.get(name).canVisit(visitsCount(name, month));
    }

    private void checkClient(String name){
        if (!membershipMap.containsKey(name)){
            throw new GymRegistryException(String.format("%s is not registered", name));
        }
    }

    public GymRegistry visit(String name, int month){
        if (!canVisit(name, month)){
            throw new GymRegistryException(String.format("Max visits per month reached for %s", name));
        }
        int currentVisits = visitsCount(name, month);
        visitsMap.get(name).put(month, currentVisits + 1);
        return this;
    }

    public int visitsCount(String name, int month){
        return visitsMap.get(name).getOrDefault(month, 0);
    }

    public int visitsCount(String name){
        checkClient(name);
        int total = 0;
        for(int amount : visitsMap.get(name).values()){
            total += amount;
        }
        return total;
    }



}
