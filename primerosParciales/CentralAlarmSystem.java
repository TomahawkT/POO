package primerosParciales;

public class CentralAlarmSystem {
    private EmergencyServices[] emergencyServices;
    public CentralAlarmSystem(EmergencyServices[] emergencyServices){
        this.emergencyServices = emergencyServices;
    }

    public EmergencyServices[] getEmergencyServices() {
        return emergencyServices;
    }
    public void setEmergencyServices(EmergencyServices[] emergencyServices){
        this.emergencyServices = emergencyServices;
    }
}
