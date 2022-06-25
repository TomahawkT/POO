package segundosParciales;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReversedListImpl<T> extends ArrayList<T> implements ReversedList<T> {
    @Override
    public Iterator<T> defaultIterator() {
        return super.iterator();
    }
    @Override
    public Iterator<T> iterator(){
        return new ReversedIterator();
    }

    private class ReversedIterator implements Iterator<T>{
        private int current;
        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            current++;
            return get(size() - current);
        }
    }

}
