package primerosParciales;

import java.util.Iterator;

public class MilesClientTester {
    public static void main(String[] args) {
        //El cliente "Chuck" se suscribe por 4 meses al plan Club 2000
        MilesClient chuck = new MilesClient("Chuck", 4, ClubType.CLUB_2000);
        for (String monthLine : chuck) {
            System.out.println(monthLine); }
        System.out.println("##########");

        MilesClient sarah = new MilesClient("Sarah", 2, ClubType.CLUB_1000);
        Iterator<String> sarahIt = sarah.iterator(); for(int i = 0; i < 2; i++) {
            System.out.println(sarahIt.next()); }
        System.out.println("##########");
        try { sarahIt.next();
        } catch (Exception ex) {
            System.out.println("Invalid Month"); }
        System.out.println("##########");

        MilesClient morgan = new MilesClient("Morgan", 6, ClubType.CLUB_5000);
        Iterator<String> morganIt = morgan.iterator(); for(int i = 0; i < 4; i++) {
            System.out.println(morganIt.next()); }
        System.out.println("##########");

        Iterator<String> chuckIt = chuck.iterator(); System.out.println(chuckIt.next()); System.out.println("##########");
        for(int i = 5; i < 7; i++) {
            System.out.println(morganIt.next()); }
        System.out.println("##########");
    }
}
