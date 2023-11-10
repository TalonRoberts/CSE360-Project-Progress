package application;
import java.util.ArrayList;
import application.Employee;

public class EmployeeDatabase {
	private static EmployeeDatabase instance;
	private ArrayList<Employee> employeeList;
	
	private EmployeeDatabase() {
		employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "Daniel", "Th59"));
		employeeList.add(new Employee(2, "Oscar", "Th59"));
		employeeList.add(new Employee(3, "Andrew", "Th59"));
		employeeList.add(new Employee(4, "Talon", "Th59"));
		employeeList.add(new Employee(5, "Angel", "Th59"));
		employeeList.add(new Employee(6, "Lynn"));
	}
	
	public static EmployeeDatabase getInstance() {
		if (instance == null) {
			instance = new EmployeeDatabase();
		}
		return instance;
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void remove(Employee employee) {
		employeeList.remove(employee);
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
