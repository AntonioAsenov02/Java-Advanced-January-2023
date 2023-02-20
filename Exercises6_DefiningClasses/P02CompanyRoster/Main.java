package Exercises6_DefiningClasses.P02CompanyRoster;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departments = new HashMap<>();

        for (int i = 1; i <= n ; i++) {

            String [] parameters = scanner.nextLine().split("\\s+");

            String name = parameters[0];
            double salary = Double.parseDouble(parameters[1]);
            String position = parameters[2];
            String department = parameters[3];

            Employee employee = null;

            if (parameters.length == 6){

                String email = parameters[4];
                int age = Integer.parseInt(parameters[5]);

                employee = new Employee(name,salary,position,department,email,age);
            } else if (parameters.length == 4) {

                employee = new Employee(name,salary,position,department);
            } else if (parameters.length == 5) {

                if (parameters[4].contains("@")){

                    String email = parameters[4];

                    employee = new Employee(name,salary,position,department,email);
                }else {

                    int age = Integer.parseInt(parameters[4]);

                    employee = new Employee(name,salary,position,department,age);
                }
            }

            if (!departments.containsKey(department)){

                departments.put(department,new ArrayList<>());
                departments.get(department).add(employee);
            }else {

                departments.get(department).add(employee);
            }
        }

        String maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n",maxAverageSalaryDepartment);

        List<Employee> employeeList = departments.get(maxAverageSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(employeeList);

        for (Employee employee : employeeList) {

            System.out.println(employee);
        }
    }

    private static double getAverageSalary(List<Employee> employeesList) {

        double sum = 0;

        for (Employee employee : employeesList) {

            sum += employee.getSalary();
        }
        return sum / employeesList.size();
    }
}
