package primerosParciales;

public abstract class Ticket {
    private final int id;
    private int rides;
    public Ticket(int id, int rides) {
        this.id = id;
        this.rides = rides;
    }
    protected abstract boolean canRideChairlift(ChairType chairlift);
    private boolean hasRidesLeft() {
        return rides > 0;
    }
    public void ride(ChairType chairlift) {
        if(!hasRidesLeft()) {
            throw new IllegalArgumentException("No more rides for ticket");
        }
        if(!canRideChairlift(chairlift)) {
            throw new IllegalArgumentException("Invalid chairlift for ticket");
        }
        rides--; }
    @Override
    public String toString() {
        return String.format("Ticket %d has %s rides left", id, rides);
    }
}