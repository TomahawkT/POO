package primerosParciales;

import java.util.Arrays;

public class AlarmSystem {
    private CentralAlarmSystem central;
    private Sensor[] sensors = new Sensor[INITIAL_DIM];
    private final String name;
    private int dim;
    private static final int INITIAL_DIM = 5;
    private static int ID = 0;
    private boolean isActivated = false;

    public AlarmSystem(CentralAlarmSystem central, String name) {
        this.central = central;
        this.name = name;
    }
    private void resize(){
        sensors = Arrays.copyOf(sensors, dim + INITIAL_DIM);
    }
    public Sensor addAlarmSensor(String name){
        if (dim == sensors.length){
            resize();
        }
        sensors[dim++] = new Sensor(name, ID++);
        return sensors[dim-1];
    }
    public void activate(){
        isActivated = true;
        System.out.println(String.format("Activando alarma de sensores de %s%n", name));
    }
    public void deactivate(){
        isActivated = false;
        System.out.println(String.format("Desactivando alarma de sensores de %s%n", name));
    }


}
