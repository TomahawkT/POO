package segundosParciales;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DoubleKeyHashMap<K1,K2,V> implements DoubleKeyMap<K1,K2,V>{
    Map<Pair<K1,K2>,V> doubleKeyMap = new HashMap<>();

    @Override
    public int size() {
        return doubleKeyMap.size();
    }

    @Override
    public boolean isEmpty() {
        return doubleKeyMap.isEmpty();
    }

    @Override
    public boolean containsKey(K1 firstKey, K2 secondKey) {
        return doubleKeyMap.containsKey(buildDoubleKey(firstKey,secondKey));
    }

    @Override
    public boolean containsValue(V value) {
        return doubleKeyMap.containsValue(value);
    }

    @Override
    public V get(K1 firstKey, K2 secondKey) {
        return doubleKeyMap.get(buildDoubleKey(firstKey,secondKey));
    }

    @Override
    public void put(K1 firstKey, K2 secondKey, V value) {
       doubleKeyMap.put(buildDoubleKey(firstKey, secondKey), value);
    }
    private Pair<K1,K2> buildDoubleKey(K1 firstKey, K2 secondKey){
        return new Pair<>(firstKey, secondKey);
    }
    private static class Pair<A,B>{
        private final A firstKey;
        private final B secondKey;
        public Pair(A firstKey, B secondKey) {
            this.firstKey = firstKey;
            this.secondKey = secondKey;
        }

        @Override
        public boolean equals(Object o){
            if (this == o){
                return true;
            }
            if (!(o instanceof Pair pair)){
                return false;
            }
            return firstKey.equals(pair.firstKey) && secondKey.equals(pair.secondKey);
        }

        @Override
        public int hashCode(){
            return Objects.hash(firstKey,secondKey);
        }
    }
}
