package primerosParciales;

public class ReachedLimitException extends Exception {
    public ReachedLimitException(int dim) {
        super(String.valueOf(dim));
    }
}
