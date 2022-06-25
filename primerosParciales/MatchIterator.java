package primerosParciales;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class MatchIterator<T> implements Iterator<MatchElement<T>> {
    private final T[] array;
    private final Predicate<T> predicate;
    private int idx;

    public MatchIterator(T[] array, Predicate<T> predicate) {
        this.array = array;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        return idx < array.length;
    }

    @Override
    public MatchElement<T> next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        T element = array[idx++];
        return new MatchElement<>(element, predicate.test(element));
    }
}
