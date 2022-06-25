package segundosParciales;

import java.util.Collection;

public class TravelGuideTester {
    public static void main(String[] args) {
        TravelGuide tG = new TravelGuide();
        // Se agrega el sitio de interés Obelisco a la ciudad Buenos Aires del país Argentina
        Landmark obelisco = new Landmark("Obelisco", 4.6);
        tG.addLandmark("Argentina", "Buenos Aires", obelisco);
        Landmark caminito = new Landmark("Caminito", 4.7);
        tG.addLandmark("Argentina", "Buenos Aires", caminito);
        Landmark stanleyPark = new Landmark("Stanley Park", 4.8);
        tG.addLandmark("Canada", "Vancouver", stanleyPark);
        Landmark cnTower = new Landmark("CN Tower", 4.6);
        tG.addLandmark("Canada", "Toronto", cnTower);
        // Se imprime la cantidad de sitios de interés de una ciudad y país determinado
        System.out.println(tG.landmarksCount("Argentina", "Buenos Aires")); // Imprime 2
        System.out.println(tG.landmarksCount("Canada", "Vancouver")); // Imprime 1
        System.out.println(tG.landmarksCount("Canada", "Toronto")); // Imprime 1
        System.out.println(tG.landmarksCount("United States", "Seattle")); // Imprime 0
        System.out.println("-----");
        // Se imprime la cantidad de sitios de interés de todas las ciudades de un país determinado
        System.out.println(tG.landmarksCount("Argentina")); // Imprime 2
        System.out.println(tG.landmarksCount("Canada")); // Imprime 2
        System.out.println(tG.landmarksCount("United States")); // Imprime 0
        System.out.println("-----");
        // Se obtienen todos los sitios de interés de la ciudad Buenos Aires del país Argentina
        // ordenados descendente por puntaje y luego alfabéticamente por nombre
        Collection<Landmark> l1 = tG.getLandmarksFromCity("Argentina", "Buenos Aires");
        for(Landmark landmark : l1) {
            System.out.println(landmark);
        }
        System.out.println("-----");
        Collection<Landmark> l2 = tG.getLandmarksFromCity("Canada", "Vancouver");
        for(Landmark landmark : l2) {
            System.out.println(landmark);
        }
        System.out.println("-----");
        Landmark gastown = new Landmark("Gastown Steam Clock", 4.4);
        tG.addLandmark("Canada", "Toronto", gastown);
        // Se obtienen todos los sitios de interés de todas las ciudades del país Canadá
        // ordenados alfabéticamente por ciudad luego descendente por puntaje y
        // luego alfabéticamente por nombre
        Collection<Landmark> l3 = tG.getLandmarksFromCountry("Canada");
        for(Landmark landmark : l3) {
            System.out.println(landmark);
        }
        System.out.println("-----");
        // Se mueve un sitio de interés de la ciudad Toronto del país Canadá
        // a la ciudad Vancouver del mismo país
        tG.moveLandmark("Canada", "Toronto", "Vancouver", new Landmark("Gastown Steam Clock", 4.4));
        Collection<Landmark> l4 = tG.getLandmarksFromCity("Canada", "Vancouver");
        for(Landmark landmark : l4) {
            System.out.println(landmark);
        }
        System.out.println("-----");
        Collection<Landmark> l5 = tG.getLandmarksFromCity("Canada", "Toronto");
        for(Landmark landmark : l5) {
            System.out.println(landmark);
        }
        System.out.println("-----");
        System.out.println(tG.getLandmarksFromCountry("United States").isEmpty()); // Imprime true
        System.out.println(tG.getLandmarksFromCity("Canada", "Yellowknife").isEmpty()); // true
        System.out.println("-----");
        Landmark dummy = new Landmark("Dummy", 1.0);
        // Falla porque no existe el país Estados Unidos
        try {
            tG.moveLandmark("United States", "Origin", "Destiny", dummy);
        } catch (TravelGuideException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("-----");
        // Falla porque no existe la ciudad de origen Yellowknife en el país Canadá
        try {
            tG.moveLandmark("Canada",  "Yellowknife", "Destiny", dummy);
        } catch (TravelGuideException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("-----");
        // Falla porque no existe el sitio de interés Dummy en la ciudad Toronto del país Canadá
        try {
            tG.moveLandmark("Canada", "Toronto", "Vancouver", dummy);
        } catch (TravelGuideException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
