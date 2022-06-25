package primerosParciales;

import java.time.LocalDate;

public class EndDateCityPass extends UnlimitedCityPass{
    private final LocalDate endDate;

    public EndDateCityPass(Attraction[] attractions, String name, LocalDate emissionDate, LocalDate endDate) {
        super(attractions, name, emissionDate);
        this.endDate = endDate;
    }
    @Override
    protected boolean canVisit(Attraction attraction, LocalDate visitDate){
        return super.canVisit(attraction, visitDate) && !visitDate.isAfter(endDate);
    }
}
