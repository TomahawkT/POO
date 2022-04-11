package TP5;

import java.util.Objects;

public class Pair<A extends Comparable<? super A>,B extends Comparable<? super B>> implements Comparable<Pair<A,B>>{
    private A a;
    private B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString(){
        return String.format("[%s, %s]", a, b);
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Pair))
            return false;
        Pair<?,?> pair = (Pair<?, ?>) o;
        if (!a.equals(pair.a))
            return false;
        return b.equals(pair.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB());
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public void setA(A a) {
        this.a = a;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public int compareTo(Pair<A, B> o) {
        int aDiff = a.compareTo(o.a);
        if (aDiff !=0){
            return aDiff;
        }
        return b.compareTo(o.b);
    }
}
