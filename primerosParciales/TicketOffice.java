package primerosParciales;

public class TicketOffice {
    private static final int TICKET_NUMBER = 1000;
    private static int ticketId = TICKET_NUMBER;
    public Ticket buySkiTicket(int rideLimit){
        return new SkiTicket(getNextTicketId(),rideLimit);
    }
    public Ticket buyVisitorTicket(int rideLimit){
        return new VisitorTicket(getNextTicketId(),rideLimit);
    }
    public void ride(Ticket ticket, ChairType chairType){
        ticket.ride(chairType);
    }
    private int getNextTicketId(){
        return ++ticketId;
    }
}
