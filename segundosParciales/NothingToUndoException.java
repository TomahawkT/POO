package segundosParciales;

public class NothingToUndoException extends RuntimeException{
    public static final String MESSAGE = "Nothing to Undo";
    public NothingToUndoException() {
        super(MESSAGE);
    }
}
