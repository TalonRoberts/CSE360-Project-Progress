package application;
import java.util.ArrayList;
import application.Employee;

public class EmployeeDatabase {
	private static EmployeeDatabase instance;
	private ArrayList<Employee> employeeList;
	
	private EmployeeDatabase() {
		employeeList = new ArrayList<>();
		employeeList.add(new Employee(9, "lynx", "meow9?"));
	}
	
	public static EmployeeDatabase getInstance() {
		if (instance == null) {
			instance = new EmployeeDatabase();
		}
		return instance;
	}
	
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public Employee getEmployee(ArrayList<Employee> list, String name) {
		for (Employee employee: list) {
			if (employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}
}
