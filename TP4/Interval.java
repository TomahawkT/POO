package TP4;

import java.util.Objects;

public class Interval {

    private double start, end, increment;

    private static final String INTERVAL_SEPARATOR = ", ";
    private static final String INTERVAL_START = "[";
    private static final String INTERVAL_END = "]";

    public Interval(double start, double end, double increment) {
        if (Math.abs(increment) < Double.MIN_VALUE) {
            throw new IllegalArgumentException("Incremento no puede ser 0");
        }
        this.start = start;
        this.end = end;
        this.increment = increment;
        if (size() == 0) {
            throw new IllegalArgumentException("Intervalo vacío.");
        }
    }

    public Interval(double start, double end) {
        this(start, end, 1);
    }

    public long size() {
        return Math.max(0, (int) ((end - start) / increment) + 1);
    }

    public double at(long lugar) {
        double answer = start + increment * lugar;
        if (lugar < 0) {
            throw new IllegalArgumentException("Fuera de los límites");
        }
        if ((increment < 0 && end <= answer && answer <= start)
                || (increment > 0 && start <= answer && answer <= end)) {
            return answer;
        }
        throw new IllegalArgumentException("Fuera de los límites");
    }

    public long indexOf(double valor) {
        double inicio, fin, incremento;
        if (start <= end) {
            inicio = start;
            fin = end;
            incremento = increment;
        } else {
            inicio = end;
            fin = start;
            incremento = -increment;
        }
        for (double rec = inicio; rec <= fin; rec += incremento) {
            if (Math.abs(rec - valor) < epsilon(valor)) {
                return Math.round((rec - start) / increment);
            }
        }
        return -1;
    }

    public boolean includes(double valor) {
        return indexOf(valor) != -1;
    }

    private double epsilon(double nro) {
        return Math.pow(2, -52 + (int) Math.log(Math.abs(nro)) / Math.log(2));
    }

    @Override
    public String toString() {
        StringBuilder auxi = new StringBuilder(INTERVAL_START);
        double rec;
        if (start <= end) {
            for (rec = start; rec <= end; rec = rec + increment) {
                auxi.append(String.valueOf(rec)).append(INTERVAL_SEPARATOR);
            }
        } else {
            for (rec = start; rec >= end; rec = rec + increment) {
                auxi.append(String.valueOf(rec)).append(INTERVAL_SEPARATOR);
            }
        }
        return auxi.substring(0, auxi.length() - 2) + INTERVAL_END;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Interval))
            return false;
        Interval interval = (Interval) o;
        if (Double.compare(interval.start, start) != 0)
            return false;
        if (Double.compare(interval.end, end) != 0)
            return false;
        return Double.compare(interval.increment, increment) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, increment);
    }

}

