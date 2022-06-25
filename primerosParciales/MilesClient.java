package primerosParciales;

import java.util.Iterator;

public class MilesClient implements Iterable<String> {
    private final String name;
    private final int months;
    private final ClubType clubType;

    public MilesClient(String name, int months, ClubType clubType) {
        this.name = name;
        this.months = months;
        this.clubType = clubType;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int month = 1;
            @Override
            public boolean hasNext() {
                return month <= months;
            }

            @Override
            public String next() {
                if (!hasNext()){
                    throw new IllegalArgumentException();
                }
                String toReturn =  String.format("Client %s: Month %d earned %d miles for $%.2f", name, month, clubType.getTotalMiles(month), clubType.getCost());
                month++;
                return toReturn;
            }
        };
    }
}
