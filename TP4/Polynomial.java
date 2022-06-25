package TP4;

public class Polynomial {

    private double[] coef;

    public Polynomial(int grade) throws InvalidGradeException {
        if (grade < 0){
            throw new InvalidGradeException();
        }
        this.coef = new double[grade+1];
    }
    public void set(int index, double value) throws InvalidIndexException {
        if (index < 0 || index > coef.length){
            throw new InvalidIndexException();
        }
        coef[index] = value;
    }
    public double eval(double x){
        double ans = 0;
        for(int i=0; i < coef.length; i++){
            ans += coef[i] * Math.pow(x,i);
        }
        return ans;
    }


}
