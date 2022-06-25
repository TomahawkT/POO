package primerosParciales;

public enum JobType {
    PART_TIME(100,0),
    FULL_TIME(200,10),
    DIRECTOR(300,20);
    private final double hourlySalary;
    private final double longevityMultiplier;

    JobType(double hourlySalary, double longevityMultiplier){
        this.hourlySalary = hourlySalary;
        this.longevityMultiplier = longevityMultiplier;
    }
    public double getSalary(int hoursWorked, int longevity){
        return hoursWorked * hourlySalary + longevity * longevityMultiplier;
    }


}
