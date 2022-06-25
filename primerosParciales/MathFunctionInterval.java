package primerosParciales;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MathFunctionInterval<T extends Comparable<? super T>> implements Iterable<T>{
    private T begin;
    private T end;
    private MathFunction<T> step;

    public MathFunctionInterval(T begin, T end, MathFunction<T> step) {
        if (begin.compareTo(end) >= 0){
            throw new IllegalArgumentException("Start no es menor que end");
        }
        this.begin = begin;
        this.end = end;
        this.step = step;
    }

    @Override
    public Iterator<T> iterator() {
        return new MathFunctionIntervalIterator();
    }
    private class MathFunctionIntervalIterator implements Iterator<T>{
        private T current = begin;
        @Override
        public boolean hasNext() {
            return current.compareTo(end) < 0;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T toReturn = current;
            current = step.evaluate(current);
            return toReturn;
        }
    }
}
