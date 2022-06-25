package primerosParciales;

public class SkiTicket extends Ticket{

    public SkiTicket(int id, int limit){
        super(id,limit);
    }
    @Override
    protected boolean canRideChairlift(ChairType chairlift) {
        return true;
    }
    @Override
    public String toString() {
        return "Ski " + super.toString();
    }
}
