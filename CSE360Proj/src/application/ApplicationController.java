package application;

import application.Employee;
import java.util.ArrayList;

public class ApplicationController {
	private static ApplicationController instance;
	private ArrayList<Employee> employeeList;
	
	private ApplicationController() {
		employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "Daniel", "danielpassword"));
	}
	
	public static ApplicationController getInstance() {
		if (instance == null) {
			instance = new ApplicationController();
		}
		return instance;
	}
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	/*public Employee searchUser(ArrayList<Employee> list, String employeeName) {
		for (Employee employee: list) {
			if (employee.getName().equals(employeeName)) {
				return employee;
			}
		}
		return null;
	}*/
}
