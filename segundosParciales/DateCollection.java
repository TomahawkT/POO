package segundosParciales;

import java.time.LocalDate;
import java.util.*;

public class DateCollection<T extends Comparable<? super T>> extends TreeSet<DateElement<T>> {
    private LocalDate today;

    public DateCollection(LocalDate today) {
        changeToday(today);
    }
    public void changeToday(LocalDate newDate){
        today = newDate;
    }

    @Override
    public boolean add(DateElement<T> elem){
        if (elem.isAfter(today)){
            throw new IllegalArgumentException();
        }
        return super.add(elem);
    }

    public Collection<T> getElementsBefore(LocalDate date){
        Collection<T> list = new ArrayList<T>();
        for(DateElement<T> elem : this){
            if(elem.isAfter(date)){
                return list;
            }
            list.add(elem.getElem());
        }
        return list;
    }

    public Collection<T> getElementsBeforeToday(){
        return getElementsBefore(today);
    }
}
