package segundosParciales;

import java.time.LocalDate;

public class DateElement <T extends Comparable<? super T>> implements Comparable<DateElement<T>>{
    private final T elem;
    private final LocalDate date;

    public DateElement(T elem, LocalDate date) {
        this.elem = elem;
        this.date = date;
    }

    @Override
    public int compareTo(DateElement<T> o) {
        int cmp = date.compareTo(o.date);
        if (cmp == 0){
            cmp = elem.compareTo(o.elem);
        }
        return cmp;
    }

    public T getElem() {
        return elem;
    }

    public boolean isAfter(LocalDate otherDate){
        return date.isAfter(otherDate);
    }
}
