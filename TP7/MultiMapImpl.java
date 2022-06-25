package TP7;

import java.util.*;

public class MultiMapImpl<K, V extends Comparable<? super V>> implements MultiMap<K, V>{

    private Map<K, Set<V>> multiMap = new HashMap<>();

    @Override
    public void put(K key, V value) {
        multiMap.putIfAbsent(key, new TreeSet<>(Comparator.reverseOrder()));
        multiMap.get(key).add(value);
    }

    @Override
    public int size() {
        int total = 0;
        for(Set<V> value : multiMap.values()){
            total += value.size();
        }
        return total;
    }

    @Override
    public int size(K key) {
        return multiMap.getOrDefault(key, new TreeSet<>()).size();
    }

    @Override
    public void remove(K key) {
        multiMap.remove(key);
    }

    @Override
    public void remove(K key, V value) {
        multiMap.getOrDefault(key, new TreeSet<>()).remove(value);
    }

    @Override
    public Iterable<V> get(K key) {
        return multiMap.get(key);
    }
}
