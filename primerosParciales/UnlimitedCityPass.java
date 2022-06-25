package primerosParciales;

import java.time.LocalDate;

public class UnlimitedCityPass implements CityPass{
    private Attraction[] attractions;
    private final String name;
    private final LocalDate emissionDate;
    private int visits;

    public UnlimitedCityPass(Attraction[] attractions, String name, LocalDate emissionDate) {
        this.name = name;
        this.emissionDate = emissionDate;
        this.attractions = attractions;
    }
    public void visit(Attraction attraction, LocalDate visitDate){
        if (!canVisit(attraction, visitDate)){
            throw new CannotVisitAttractionException(String.format("Cannot Visit Attraction %s",attraction.toString()));
        }
        visits++;
        System.out.println(String.format("%s visited %s",name, attraction.toString()));
    }
    protected boolean canVisit(Attraction attraction, LocalDate visitDate){
        return belongsIn(attraction) && visitDate.isAfter(emissionDate);
    }
    @Override
    public Attraction[] getAttractions() {
        return attractions;
    }
    @Override
    public String toString(){
        return String.format("CityPass for %s used for %d attractions", name, visits);
    }
    protected int getVisits() {
        return visits;
    }
}
