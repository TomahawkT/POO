package TP5;

import java.util.Arrays;
import java.util.EmptyStackException;


public class ArrayStack<E> implements Stack<E>{

    private E[] elements;
    private static final int INITIAL_DIM = 10;
    private int dim;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (E[]) new Object[INITIAL_DIM];
    }

    @Override
    public void push(E var) {
        if (dim == elements.length){
            resize();
        }
        elements[dim++] = var;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return elements[--dim];
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return elements[dim-1];
    }

    @Override
    public boolean isEmpty() {
        return dim == 0;
    }

    protected void resize(){
        elements = Arrays.copyOf(elements, elements.length + INITIAL_DIM);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i=dim-1; i >= 0; i--){
            stringBuilder.append(elements[i]).append(",");
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ']');
        return stringBuilder.toString();
    }

    protected int getDim(){
        return dim;
    }

}
