package segundosParciales;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public interface SpecialCollection<T extends Comparable<? super T>> extends Set<T> {
    default void deleteFirst(){
        deleteFirst(first -> true);
    }

    void deleteFirst(Predicate<T> condition);

    void undoDeleteFirst();
}
