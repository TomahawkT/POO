package primerosParciales;

public class VisitorTicket extends Ticket{
    public VisitorTicket(int id, int limit){
        super(id,limit);
    }

    @Override
    protected boolean canRideChairlift(ChairType chairlift) {
        return !chairlift.forSkier();
    }

    @Override
    public String toString() {
        return "Visitor " + super.toString();
    }

}
