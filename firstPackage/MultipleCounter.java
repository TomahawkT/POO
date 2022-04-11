package firstPackage;

public class MultipleCounter extends Counter{

    private int times;
    public MultipleCounter(int times) {
        this.times = times;
    }

    @Override
    public void increment() {
        super.setCount(super.getCount()+times);
    }

    @Override
    public void decrement() {
        super.setCount(super.getCount()-times);
    }
}

