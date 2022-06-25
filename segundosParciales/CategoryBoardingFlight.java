package segundosParciales;

import java.util.Comparator;

public class CategoryBoardingFlight extends BoardingFlight{
    public CategoryBoardingFlight() {
        super(Comparator.comparing(Passenger::getCategory).thenComparing(Passenger::getName));
    }
}
