package TP6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TimeSetImpl<T extends Comparable<? super T>> implements TimeSet<T> {

    private Set<TimeData<T>> data = new TreeSet<>(Comparator.<TimeData<T>>comparingInt(TimeData::getHours)
            .thenComparingInt(TimeData::getMinutes).thenComparing(TimeData::getElem));

    @Override
    public void add(T elem, int hours, int minutes) {
        TimeData<T> timeData = new TimeData<>(elem, hours, minutes);
        data.remove(timeData.getElem());
        data.add(timeData);
    }

    @Override
    public void remove(T elem) {
        data.remove(new TimeData<>(elem));
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean contains(T elem) {
        return data.contains(new TimeData<>(elem));
    }

    @Override
    public Set<T> retrieve(int hoursFrom, int minutesFrom, int hoursTo, int minutesTo) {
        if (hoursFrom > hoursTo || hoursFrom == hoursTo && minutesFrom > minutesTo){
            throw new IndexOutOfBoundsException();
        }
        Set<T> response = new HashSet<>();
        for (TimeData<T> timeData : data){
            if (timeData.getHours() > hoursTo){
                break;
            }
            if (timeData.between(hoursFrom, minutesFrom, hoursTo, minutesTo)){
                response.add(timeData.getElem());
            }
        }
        return response;
    }
}
