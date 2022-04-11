package TP4;

public enum ExtendedOperation implements Operation {

    EXP("^", (x, y) -> Math.pow(x, y)),
    REMAINDER("%", (x, y) -> x % y);

    private final String symbol;
    private final Operation operation;

    ExtendedOperation(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public double apply(double x, double y) {
        return operation.apply(x, y);
    }
}

