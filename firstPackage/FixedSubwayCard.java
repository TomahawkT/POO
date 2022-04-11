package firstPackage;

public class FixedSubwayCard extends SubwayCard {
    private int rides;

    public FixedSubwayCard(SubwayCentral sc, int rides) {
        super(sc);
        this.rides = rides;
    }

    protected boolean canRide(){
        return rides > 0;
    }

    public void ride() throws CannotRideException{
        if (canRide()) {
            rides--;
        }
        else{
            throw new CannotRideException();
        }
    }
}
