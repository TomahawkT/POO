package segundosParciales;

import java.util.*;

public abstract class BoardingFlight {
    private final Set<Passenger> passengerSet;

    public BoardingFlight(Comparator<Passenger> passengerComparator) {
        passengerSet = new TreeSet<>(passengerComparator);
    }

    public void addForBoarding(String name, int seatRow, PassengerCategory passengerCategory){
        passengerSet.add(new Passenger(name, seatRow, passengerCategory));
    }

    public Iterator<String> boardingCallIterator(){
        return new Iterator<String>() {
            private final Iterator<Passenger> it = passengerSet.iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public String next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return it.next().getName();
            }
        };
    }
}
