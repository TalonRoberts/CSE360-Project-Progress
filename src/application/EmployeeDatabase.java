package application;
import java.util.ArrayList;
import application.Employee;
import application.EmployeeReader;

public class EmployeeDatabase {
	private static EmployeeDatabase instance;
	private ArrayList<Employee> employeeList;
	private Employee currentEmployee;
	
	private EmployeeDatabase() {
		employeeList = new ArrayList<>();
	}
	
	public static EmployeeDatabase getInstance() {
		if (instance == null) {
			instance = new EmployeeDatabase();
		}
		return instance;
	}
	
	public ArrayList<Employee> loadDatabase(String filename) {
		employeeList = EmployeeReader.readEmployeesFromFile(filename);
		return employeeList;
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
	public Employee getEmployee(ArrayList<Employee> list, int id) {
		for (Employee employee: list) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}
	public void setCurrentEmployee(Employee employee){
		currentEmployee = employee;
	}
	public Employee getCurrentEmployee() {
		return currentEmployee;
	}
}
