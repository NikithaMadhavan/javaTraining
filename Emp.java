package java_demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Emp {
    public static void main(String[] args) throws InterruptedException {
        EmployeeManager employeeManager = new EmployeeManager();
        Thread thread = new Thread(employeeManager);
        thread.start();
        thread.join();

        System.out.println("Sorted by Age:");
        employeeManager.getEmployees().forEach(employee ->
                System.out.println("Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Salary: " + employee.getSalary()));

        System.out.println("\nSorted by Salary:");
        employeeManager.sortEmployeesBySalary();
        employeeManager.getEmployees().forEach(employee ->
                System.out.println("Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Salary: " + employee.getSalary()));
    }

    public static class Employee {
        private String name;
        private int age;
        private double salary;

        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static class EmployeeManager implements Runnable {
        private List<Employee> employees = new ArrayList<>();

        public void addEmployee(Employee employee) {
            employees.add(employee);
        }

        public void sortEmployeesByAge() {
            employees.sort(Comparator.comparingInt(Employee::getAge));
        }

        public void sortEmployeesBySalary() {
            employees.sort(Comparator.comparingDouble(Employee::getSalary));
        }

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 1; i < 10; i++) {
                Employee employee = new Employee("Employee" + i, random.nextInt(40) + 20, 20000 + random.nextInt(30000));
                addEmployee(employee);
            }
            sortEmployeesByAge();
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }
}
