package firstPackage;

public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    protected void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

}

