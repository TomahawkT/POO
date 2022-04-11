 package firstPackage;

public class SubwayCardTester {

    public static void main(String[] args) {
        SubwayCentral sc = new SubwayCentral(25);

        FixedSubwayCard fsc = new FixedSubwayCard(sc, 2);
        try {
            fsc.ride();
        }catch (CannotRideException e){
            System.err.println(e.getMessage());
        }
        try {
            fsc.ride();
        }catch (CannotRideException e) {
            System.err.println(e.getMessage());
        }
        try {
            fsc.ride();
        }catch (CannotRideException e) {
            System.err.println(e.getMessage());
        }

        RechargeableSubwayCard rsc = new RechargeableSubwayCard(sc);
        rsc.recharge(50);
        try {
            rsc.ride();
        }catch (CannotRideException e) {
            System.err.println(e.getMessage());
        }
        sc.setRideCost(30);
        try {
            rsc.ride();
        }catch (CannotRideException e) {
            System.err.println(e.getMessage());
        }

        DiscountRechargeableSubwayCard drsc = new DiscountRechargeableSubwayCard(sc, 0.50);
        drsc.recharge(30);
        try {
            drsc.ride();
        }catch (CannotRideException e) {
            System.err.println(e.getMessage());
        }
        try {
            drsc.ride();
        }catch (CannotRideException e) {
            System.err.println(e.getMessage());
        }
        try {
            drsc.ride();
        }catch (CannotRideException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("OK!");
    }

}