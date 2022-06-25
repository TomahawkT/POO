package segundosParciales;

public class Passenger {
    private final String name;
    private final int seatRow;
    private final PassengerCategory category;

    public Passenger(String name, int seatRow, PassengerCategory category) {
        this.name = name;
        this.seatRow = seatRow;
        this.category = category;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public String getName() {
        return name;
    }

    public PassengerCategory getCategory() {
        return category;
    }

}
