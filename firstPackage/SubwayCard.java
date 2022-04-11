package firstPackage;

public abstract class SubwayCard {
    private SubwayCentral subwayCentral;

    SubwayCard(SubwayCentral sc){
        subwayCentral = sc;
    }
    abstract protected boolean canRide();
    public abstract void ride() throws CannotRideException;
    protected double getRideCost() {
        return subwayCentral.getRideCost();
    }

}
