package primerosParciales;

import java.time.LocalDate;

public class CityPassTester {
    public static void main(String[] args) {
        Attraction laGrandeRoue = new Attraction("La Grande Roue de Montreal");
        Attraction oasisImm = new Attraction("OASIS Immersion");
        Attraction mtlZipline = new Attraction("MTL Zipline");
        Attraction[] attractions = new Attraction[]{laGrandeRoue, oasisImm, mtlZipline};

        CityPass unlimitedCP = new UnlimitedCityPass(attractions, "Olivia", LocalDate.of(2022, 4, 16));
        System.out.println(unlimitedCP);
        System.out.println("##########");

        unlimitedCP.visit(laGrandeRoue, LocalDate.of(2022, 4, 17));
        unlimitedCP.visit(oasisImm, LocalDate.of(2022, 4, 17));
        unlimitedCP.visit(new Attraction("MTL Zipline"), LocalDate.of(2022, 4, 18));
        System.out.println("##########");

        try {
        //Falla porque la atracción que no está aceptada
            unlimitedCP.visit(new Attraction("Notre-Dame Basilica of Montreal"), LocalDate.of(2022, 4, 16));
        } catch (CannotVisitAttractionException ex) {
            System.out.println(ex.getMessage());
        }
        try {
        //Falla porque la fecha de visita es anterior a la fecha del pase
            unlimitedCP.visit(laGrandeRoue, LocalDate.of(2022, 4, 15)); }
        catch (CannotVisitAttractionException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("##########");
        System.out.println(unlimitedCP);
        System.out.println("##########");

        CityPass limitedVisitsCP = new LimitedVisitsCityPass(attractions, "Peter", LocalDate.of(2022, 4, 16), 2);
        limitedVisitsCP.visit(laGrandeRoue, LocalDate.of(2022, 4, 17));
        limitedVisitsCP.visit(oasisImm, LocalDate.of(2022, 4, 18));
        try {
            //Falla porque ya se alcanzó el límite de visitas
            limitedVisitsCP.visit(mtlZipline, LocalDate.of(2022, 4, 18)); }
        catch (CannotVisitAttractionException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(limitedVisitsCP);
        System.out.println("##########");

        CityPass endDateCP = new EndDateCityPass(attractions, "Walter", LocalDate.of(2022, 4, 16), LocalDate.of(2022, 4, 19));
        endDateCP.visit(laGrandeRoue, LocalDate.of(2022, 4, 17));
        endDateCP.visit(oasisImm, LocalDate.of(2022, 4, 19));
        try {
            //Falla porque la fecha de visita es posterior a la fecha del vencimiento
            endDateCP.visit(mtlZipline, LocalDate.of(2022, 4, 20)); }
        catch (CannotVisitAttractionException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(endDateCP);
        System.out.println("##########");
    }
}
