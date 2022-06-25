package segundosParciales;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredKeyMapIterator<K,V> implements Iterator<K> {

    private final Iterator<Map.Entry<K,V>> iterator;
    private final Predicate<K> keyPredicate;
    private V currentValue;
    public FilteredKeyMapIterator(Map<K,V> map, Predicate<K> keyPredicate) {
        this.iterator = map.entrySet().iterator();
        this.keyPredicate = keyPredicate;
    }


    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public K next() {
        while (hasNext()) {
            Map.Entry<K, V> currentEntry = iterator.next();
            if (keyPredicate.test(currentEntry.getKey())) {
                currentValue = currentEntry.getValue();
                return currentEntry.getKey();
            }
        }
        throw new NoSuchElementException();
    }

    public V getValue() {
        if(currentValue == null){
            throw new NoSuchElementException();
        }
        return currentValue;
    }

}
