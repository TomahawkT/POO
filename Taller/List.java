package Taller;

import java.util.Comparator;
import java.util.Iterator;

public interface List <T> extends Iterable<T>{
    boolean contains (T elem);
    int getIdx(T elem);
    boolean add (T elem);
    boolean isEmpty();
    boolean remove(int idx);

    default boolean removeElement(T elem){
        int idx = getIdx(elem);
        if (idx != -1){
            return remove(idx);
        }
        return false;
    }

    public abstract Iterator<T> customIterator(Comparator<T> comparator);
}
