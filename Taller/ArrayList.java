package Taller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

    private T[] arr;
    private static final int INITIAL_CAPACITY = 5;
    private int dim = 0;
    private final Comparator <T> comparator;

    public ArrayList(Comparator<T> comparator) {
        arr = (T[]) new Object[INITIAL_CAPACITY];
        this.comparator = comparator;
    }

    @Override
    public boolean contains(T elem) {
        return getIdx(elem) != -1;
    }

    @Override
    public int getIdx(T elem) {
        for (int i = 0; i < dim; i++) {
            if (arr[i].equals(elem)){
                return 1;
            }
        }
        return -1;
    }

    @Override
    public boolean add(T elem) {
        if (dim == arr.length){
            expand();
        }
        arr[dim++] = elem;
        return true;
    }

    private void expand(){
        arr = Arrays.copyOf(arr, arr.length*2);
    }
    @Override
    public boolean isEmpty() {
        return dim == 0;
    }

    @Override
    public boolean remove(int idx) {
        if (idx < 0 || idx >= dim){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(arr, idx+1, arr, idx, arr.length - idx -1);
        dim--;
        return false;
    }

    @Override
    public Iterator<T> customIterator(Comparator<T> comparator) {
        T[] aux = Arrays.copyOf(arr, dim);
        Arrays.sort(aux, comparator);
        return new ArrayListIterator(aux);
    }

    @Override
    public Iterator<T> iterator() {
        return customIterator(Comparator.naturalOrder());
    }

    private class ArrayListIterator implements Iterator<T>{
        private int iter = 0;
        private T[] aux;

        public ArrayListIterator(T[] aux) {
            this.aux = aux;
        }

        @Override
        public boolean hasNext() {
            return iter < dim;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return arr[iter++];
        }
    }
}
