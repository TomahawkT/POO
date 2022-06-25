package segundosParciales;

import java.util.Comparator;

public class RowBoardingFlight extends BoardingFlight{
    public RowBoardingFlight() {
        super(Comparator.comparingInt(Passenger::getSeatRow).thenComparing(Passenger::getName));
    }
}
