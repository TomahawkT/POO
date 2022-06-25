package TP7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConcatIterator<E> implements Iterator<E> {

    private Iterator<E> iterator1, iterator2;

    public ConcatIterator(Iterator<E> iterator1, Iterator<E> iterator2) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
    }

    @Override
    public boolean hasNext() {
        if (!iterator1.hasNext() && iterator1 != iterator2){
            iterator1 = iterator2;
        }
        return iterator1.hasNext();
    }

    @Override
    public E next() {
        if (!iterator1.hasNext()){
            throw new NoSuchElementException();
        }
        return iterator1.next();
    }
}
