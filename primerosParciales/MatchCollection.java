package primerosParciales;

import java.util.Iterator;
import java.util.function.Predicate;

public class MatchCollection<T> implements Iterable<MatchElement<T>>{
    private Predicate<T> condition;
    private final T[] elements;
    public MatchCollection(T[] elements) {
        this(elements, new Predicate<T>() {
            @Override
            public boolean test(T e) {
                return true;
            }
        });
    }
    public MatchCollection(T[] elements, Predicate<T> condition) {
        this.elements = elements;
        this.condition = condition;
    }

    public void setCondition(Predicate<T> condition) {
        this.condition = condition;
    }

    @Override
    public Iterator<MatchElement<T>> iterator() {
        return new MatchIterator2();
    }
    private class MatchIterator2 implements Iterator<MatchElement<T>>{
        private int idx;
        private final Predicate<T> itCondition = condition;
        @Override
        public boolean hasNext() {
            return idx < elements.length;
        }

        @Override
        public MatchElement<T> next() {
            if (!hasNext()){
                throw new IllegalArgumentException();
            }
            T elem = elements[idx++];
            return new MatchElement<>(elem, itCondition.test(elem));
        }
    };
}
