package primerosParciales;

public enum EmergencyServices {
    POLICE("Policia", 911),
    HEALTH("Ambulancia",107),
    FIRE("Bomberos", 100);
    private final int phoneNumber;
    private final String name;
    EmergencyServices(String name,int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return String.format("Llamando a %s al %d", name, phoneNumber);
    }

}
