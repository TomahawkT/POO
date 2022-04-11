package firstPackage;

public class RechargeableSubwayCard extends SubwayCard{
    private double balance = 0;

    public RechargeableSubwayCard(SubwayCentral sc) {
        super(sc);
    }

    public void recharge(double balance){
        this.balance += balance;
    }
    protected double rideCost(){
        return getRideCost();
    }
    protected boolean canRide(){
        return balance - rideCost() >= 0;
    }
    public void ride() throws CannotRideException {
        if ((balance -= rideCost()) < 0){
            throw new CannotRideException();
        }
    }
}
