package primerosParciales;

import TP4.InvalidIndexException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Dictionary<K extends Comparable<? super K>>{
    public static final int INITIAL_DIM = 5;
    private DictionaryEntry<K>[] entries = new DictionaryEntry[INITIAL_DIM];
    private int dim;

    private void resize(){
        entries = Arrays.copyOf(entries, entries.length + INITIAL_DIM);
    }

    public Dictionary<K> addEntry(K word, String definition){
        if(dim == entries.length){
            resize();
        }
        entries[dim++] = new DictionaryEntry<>(word, definition);
        return this;
    }

    public DictionaryEntry<K>[] getNaturalOrderCopy(){
        return getCopy(Comparator.naturalOrder());
    }
    public DictionaryEntry<K>[] getReverseOrderCopy(){
        return getCopy(Comparator.reverseOrder());
    }
    private DictionaryEntry<K>[] getCopy(Comparator<DictionaryEntry<K>> comparator){
        DictionaryEntry<K>[] toReturn = Arrays.copyOf(entries,entries.length);
        Arrays.sort(toReturn, comparator);
        return toReturn;
    }
    public DictionaryEntry<K> getFirstMatch(Predicate<K> predicate){
        for (DictionaryEntry<K> entry : entries) {
            if (predicate.test(entry.getWord())) {
                return entry;
            }
        }
        throw new IllegalArgumentException();
    }
}
