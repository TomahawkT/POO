//package Parciales;
//
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class MultiIterator implements Iterator<E> {
//
//    private static final int INITIAL_DIM = 2;
//    private Iterator<E>[] iterators = (Iterator<E>[]) new Iterator[INITIAL_DIM];
//    private int dim;
//    private boolean started;
//
//    public MultiIterator() {
//    }
//
//    public void add( Iterator<E> elem){
//        if (started){
//            throw new MultiIteratorException();
//        }
//        if (dim == iterators.length){
//            resize();
//        }
//        iterators[dim++] = elem;
//
//    }
//    private void resize() {
//        iterators = Arrays.copyOf(iterators, iterators.length + INITIAL_DIM);
//    }
//
//    public int size(){return dim;}
//
//    @Override
//    public boolean hasNext() {
//        for (int i=0; i < dim; i++){
//            if (iterators[i].hasNext()){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public E next() {
//        if (!hasNext()){
//            throw new NoSuchElementException();
//        }
//        started = true;
//        for(int i=0; i < dim; i++){
//            if (iterators[i].hasNext()){
//                return iterators[i].next();
//            }
//        }
//        throw new IllegalStateException();
//    }
//}
