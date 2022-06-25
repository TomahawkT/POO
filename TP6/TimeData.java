package TP6;

import java.util.Objects;

public class TimeData<T extends Comparable<? super T>> {
    private T elem;
    private int hours;
    private int minutes;

    public TimeData(T elem, int hours, int minutes) {
        this.elem = elem;
        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeData(T elem) {
        this.elem = elem;
    }

    public T getElem() {
        return elem;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof TimeData)){
            return false;
        }
        TimeData<?> timeData = (TimeData<?>) o;
        return getElem().equals(timeData.getElem());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getElem());
    }

    public boolean between(int hoursFrom, int minutesFrom, int hoursTo, int minutesTo){
        return (hours > hoursFrom || hours == hoursFrom && minutes >= minutesFrom) &&
                (hours < hoursTo || hours == hoursTo && minutes <= minutesTo);
    }
}
