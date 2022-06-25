package TP7;

import Taller.List;

public interface SimpleList<E> extends List<E> {
    <T> T reduce(T initialValue, Reducer<E, T> reducer);
}
