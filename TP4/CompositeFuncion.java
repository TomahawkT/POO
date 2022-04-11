package TP4;

public class CompositeFuncion implements Function{
    Function f1,f2;

    public CompositeFuncion(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double evaluate(double x) {
        return f2.evaluate(f1.evaluate(x));
    }

}
