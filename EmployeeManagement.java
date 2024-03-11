package java_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeManagement {
	private static final int NUM_EMPLOYEES = 10;

	private List<Employee> employees = new ArrayList<>();

	public void addRandomEmployees() {
		Random random = new Random();
		for (int i = 0; i < NUM_EMPLOYEES; i++) {
			String name = "Employee" + (i + 1);
			int age = random.nextInt(40) + 20;
			int salary = random.nextInt(100000) + 50000;
			employees.add(new Employee(name, age, salary));
		}
	}

//    public void displayEmployees() {
//        System.out.println("Employees:");
//        employees.forEach(System.out::println);
//    }

	public void sortAndDisplay() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {

			employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
			System.out.println("\nAfter sorting by age:");
			employees.forEach(System.out::println);

			employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
			System.out.println("\nAfter sorting by salary:");
			employees.forEach(System.out::println);

			executor.shutdown();
		});
	}
}
