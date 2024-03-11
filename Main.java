package java_demo;

public class Main {
	public static void main(String[] args) {
		EmployeeManagement employeeManagement = new EmployeeManagement();
		employeeManagement.addRandomEmployees();
//        employeeManagement.displayEmployees();
		employeeManagement.sortAndDisplay();
	}
}
