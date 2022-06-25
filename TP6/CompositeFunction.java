package TP6;

import TP4.Function;

import java.util.*;

public class CompositeFunction implements Function {
    private List<Function> fn;

    public CompositeFunction() {
        this.fn = new ArrayList<>();
    }
    public void addFunction(Function function){
        fn.add(function);
    }
    @Override
    public double evaluate(double x) {
        double answer = x;
        if (fn.isEmpty()){
            throw new IllegalStateException();
        }
        for(Function function: fn){
            answer = function.evaluate(answer);
        }
        return answer;
    }
}
