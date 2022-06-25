package primerosParciales;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class School {
    private Employee[] employees = new Employee[INITIAL_DIM];
    public static final int INITIAL_DIM = 5;
    private int dim;
    public void hireEmployee(String name, int longevity, JobType jobType){
        if(dim == employees.length){
            resize();
        }
        employees[dim++] = new Employee(name, longevity, jobType);
    }
    private void resize(){
        employees = Arrays.copyOf(employees, employees.length + INITIAL_DIM);
    }
    public double getSalary(String name, int hoursWorked){
        for(int i=0;i < dim; i++){
            if(Objects.equals(name, employees[i].getName())){
                return employees[i].getSalary(hoursWorked);
            }
        }
        throw new NoSuchElementException("Employee not found");
    }
    public Employee[] employees(){
        Employee[] toReturn = Arrays.copyOf(employees,dim);
        Arrays.sort(toReturn);
        return toReturn;
    }
}
