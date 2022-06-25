package primerosParciales;

public class Sensor {
    private final String name;
    private final int id;

    public Sensor(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void motionDetected(){
        System.out.println(toString() + " detecto movimiento");
    }
    @Override
    public String toString(){
        return String.format("Sensor %s (ID: %d)", name, id);
    }
}

