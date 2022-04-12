package TP5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicWindowIrerator<E> implements Iterator<E[]> {

    private final E[] elements;
    private int windowDim, idx;

    public CyclicWindowIrerator(E[] elements, int windowDim) {
        this.elements = elements;
        this.windowDim = windowDim;
        this.idx = elements.length;
    }

    @Override
    public boolean hasNext() {
        return elements.length != 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        E[] window = (E[]) new Object[windowDim];
        for (int i = 0; i < windowDim; i++) {
            window[i] = elements[(idx + 1) % elements.length];
        }
        idx++;
        return window;
    }
}
