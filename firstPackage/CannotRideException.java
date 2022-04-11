package firstPackage;

public class CannotRideException extends Exception {
    private static final String MESSAGE =
            "No puede viajar";

    public CannotRideException() {
        super(MESSAGE);
    }
}