package primerosParciales;

public class Employee implements Comparable<Employee>{
    private final String name;
    private final int longevity;
    private final JobType jobType;

    public Employee(String name, int longevity, JobType jobType) {
        this.name = name;
        this.longevity = longevity;
        this.jobType = jobType;
    }
    @Override
    public String toString(){
        return String.format("<%s # %d %s>",name, longevity, longevity>1 ? "años" : "año");
    }
    public String getName() {
        return name;
    }
    public double getSalary(int hoursWorked){
        return jobType.getSalary(hoursWorked, longevity);
    }

    @Override
    public int compareTo(Employee o) {
        int cmp = Integer.compare(longevity, o.longevity);
        if (cmp == 0){
            return o.name.compareTo(name);
        }
        return cmp;
    }
}
