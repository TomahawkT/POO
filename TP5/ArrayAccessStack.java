package TP5;

public class ArrayAccessStack<E> extends ArrayStack<E> implements AccessStack<E>{

    private int popAccesses;

    public ArrayAccessStack() {
        super();
    }

    @Override
    public int getPopAccesses() {
        return popAccesses;
    }

    @Override
    public int getPushAccesses() {
        return getDim() + popAccesses;
    }

    @Override
    public E pop() {
        E toReturn = super.pop();
        popAccesses++;
        return toReturn;
    }
}
