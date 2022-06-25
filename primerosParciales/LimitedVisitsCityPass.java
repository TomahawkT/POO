package primerosParciales;

import java.time.LocalDate;

public class LimitedVisitsCityPass extends UnlimitedCityPass{
    private final int maxVisits;

    public LimitedVisitsCityPass(Attraction[] attractions, String name, LocalDate emissionDate, int maxVisits) {
        super(attractions, name, emissionDate);
        this.maxVisits = maxVisits;
    }

    @Override
    protected boolean canVisit(Attraction attraction, LocalDate visitDate){
        return super.canVisit(attraction,visitDate) && getVisits() < maxVisits;
    }
}
