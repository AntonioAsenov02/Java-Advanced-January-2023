package ClassesExercises.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){

        if (employees.size() < this.capacity){
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){

        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employees.remove(employee);
            }
        }
        return false;
    }
    public Employee getOldestEmployee(){

        return employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }
    public Employee getEmployee(String name){

        Employee employee = null;

        for (Employee currentEmployee : employees) {
            if (currentEmployee.getName().equals(name)){
                employee = currentEmployee;
            }
        }
        return employee;
    }
    public int getCount(){
        return employees.size();
    }
    public String report(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Employees working at Cafe %s%n",this.name));

        for (Employee employee : employees) {
            builder.append(employee).append("\n");
        }
        return builder.toString();
    }
}
