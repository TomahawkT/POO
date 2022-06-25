package primerosParciales;

import java.util.Iterator;

public class TVCatalogTester {
    public static void main(String[] args) {
        TVCatalog tvCatalog = new ArrayTVCatalog();
        tvCatalog.addTVShow("Mythic Quest", 7.7).addTVShow("Mr. Mayor", 6.1).addTVShow("The Flight Attendant", 7.1);
        System.out.println("----------");
        // Todos los programas de TV dirán In Range
        // porque entran en el rango por defecto.
        for (TVResponse tvResponse : tvCatalog) {
            System.out.println(tvResponse);
        }
        System.out.println("----------");
        // Se setea un rango de rating
        tvCatalog.setRatingRange(7.0, 10.0);
        System.out.println("----------");
        // Los programas de tv con rating entre 7 y 10 dirán In Range.
        // Los demás dirán Out of Range.
        for (TVResponse tvResponse : tvCatalog) {
            System.out.println(tvResponse);
        }
        System.out.println("----------");
        Iterator<TVResponse> secondIt = tvCatalog.iterator();
        System.out.println("----------");
        tvCatalog.addTVShow("Sherlock", 9.1);
        System.out.println("----------");
        // Se setea un rango de rating
        tvCatalog.setRatingRange(8.0, 10.0);
        System.out.println("----------");
        // Los programas de tv con rating entre 7 y 10 dirán In Range.
        // Los demás dirán Out of Range.
        while (secondIt.hasNext()) {
            System.out.println(secondIt.next());
        }
        System.out.println("----------");
        // Los programas de tv con rating entre 8 y 10 dirán In Range.
        // Los demás dirán Out of Range.
        Iterator<TVResponse> thridIt = tvCatalog.iterator();
        while (thridIt.hasNext()) {
            System.out.println(thridIt.next());
        }
        System.out.println("----------");
        TVCatalog emptyTVCatalog = new ArrayTVCatalog();
        System.out.println(emptyTVCatalog.iterator().hasNext()); // Imprime false
        System.out.println("----------");
        try {
            // Lanza un error si los parámetros mínimo o máximo son incorrectos
            tvCatalog.setRatingRange(-1.0, 9.0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("----------");
    }
}
