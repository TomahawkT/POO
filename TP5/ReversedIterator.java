package TP5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReversedIterator<T> implements Iterator<T>{

    private final T[] elements;
    private int idx;

    public ReversedIterator(T[] elements) {
        this.elements = elements;
        this.idx = elements.length;
    }

    @Override
    public boolean hasNext() {
        return idx >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return elements[idx--];
    }
}
