package primerosParciales;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParallelIterator<T> implements Iterator<ParallelIterator.Pair<T>> {
    private T[] v1;
    private T[] v2;
    private int idx;

    public ParallelIterator(T[] v1, T[] v2) {
        if (v1 == null){
            throw new RuntimeException("First collection missing");
        }
        if (v2 == null){
            throw new RuntimeException("Second collection missing");
        }
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean hasNext() {
        return idx < v1.length && idx < v2.length;
    }

    @Override
    public Pair<T> next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        Pair<T> toReturn = new Pair<>(v1[idx], v2[idx]);
        idx++;
        return toReturn;
    }
    public static class Pair<E> {
        private final E left, right;

        Pair(E left, E right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.format("{%s,%s}", left, right);
        }
    }
}
