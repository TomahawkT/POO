package TP4;

public class InvalidGradeException extends Exception{
    private static final String MESSAGE = "Indice invalido";

    public InvalidGradeException() {
        super(MESSAGE);
    }
}
