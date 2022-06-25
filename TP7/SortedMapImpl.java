package TP7;

import com.sun.source.tree.Tree;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SortedMapImpl<K extends Comparable<? super K>,V> extends
        TreeMap<K,V> implements SortedMap<K,V> {
    @Override
    public K higherKey() {
        return higherEntry().getKey();
    }

    @Override
    public V higherValue() {
        return higherEntry().getValue();
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return entrySet().iterator();
    }

    private Map.Entry<K,V> higherEntry(){
        return iterator().next();
    }
}
