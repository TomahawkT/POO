package TP6;

public interface Bag<T> {
    void add(T elem);
    void remove(T elem);
    boolean contains(T elem);
    int count(T elem);
    int size();
    int sizeDistinct();
}
