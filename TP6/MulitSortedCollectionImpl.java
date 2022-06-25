package TP6;

import java.util.*;

public class MulitSortedCollectionImpl<T> implements MultiSortedCollection<T>{

    private Set<T> data = new HashSet<>();
    private Map<Comparator<T>, Set<T>> multiSortedData = new HashMap<>();

    @Override
    public void add(Comparator<T> comp) {
        TreeSet<T> newSet = new TreeSet<>(comp);
        newSet.addAll(data);
        multiSortedData.put(comp, newSet);
    }

    @Override
    public void add(T elem) {
        data.add(elem);
        if (!multiSortedData.isEmpty()){
            multiSortedData.values().forEach(set -> set.add(elem));
        }
    }

    @Override
    public void remove(T elem) {
        data.remove(elem);
        if (!multiSortedData.isEmpty()){
            multiSortedData.values().forEach(set -> set.remove(elem));
        }
    }

    @Override
    public Iterable<T> iterable(Comparator<T> comp) {
        if(!multiSortedData.containsKey(comp)){
            throw new IllegalStateException();
        }
        return multiSortedData.get(comp);
    }
}
