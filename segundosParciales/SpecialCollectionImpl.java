package segundosParciales;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.function.Predicate;

public class SpecialCollectionImpl<T extends Comparable<? super T>> extends TreeSet<T> implements SpecialCollection<T>{
    private T lastDeleted;

    public SpecialCollectionImpl(){
        super(Comparator.reverseOrder());
    }
    @Override
    public void deleteFirst(Predicate<T> condition) {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (condition.test(this.first())) {
            lastDeleted = this.first();
            this.remove(lastDeleted);
        }
    }

    @Override
    public void undoDeleteFirst() {
        if (lastDeleted == null){
            throw new NothingToUndoException();
        }
        add(lastDeleted);
        lastDeleted = null;
    }
}
