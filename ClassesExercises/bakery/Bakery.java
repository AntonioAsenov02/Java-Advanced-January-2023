package ClassesExercises.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){

        if (employees.size() < capacity){
            employees.add(employee);
        }
    }

    public boolean remove(String name){

        for (Employee employee : employees) {

            if (employee.getName().equals(name)){

                return employees.remove(employee);
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){

       return employees.stream().max(Comparator.comparing(Employee::getAge)).get();
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

        builder.append(String.format("Employees working at Bakery %s:",name)).append("\n");
        for (Employee employee : employees) {
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
