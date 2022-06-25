package TP7;

@FunctionalInterface
public interface Criteria<T> {
    boolean satisfies(T obj);
}
