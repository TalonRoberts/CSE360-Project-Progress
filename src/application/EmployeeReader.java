package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import application.Employee;

public class EmployeeReader {

	public static ArrayList<Employee> readEmployeesFromFile(String filePath) {
	    ArrayList<Employee> employees = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            // Split the line into components (assuming they are separated by a delimiter like comma)
	            String[] parts = line.split(",");

	            // Check if the array has enough elements
	            if (parts.length >= 3) {
	                // Parse the components and create an Employee object
	                int id = Integer.parseInt(parts[0]);
	                String username = parts[1];
	                String password = parts[2];

	                Employee employee = new Employee(id, username, password);
	                employees.add(employee);
	            } else {
	                System.out.println("Skipping line: " + line);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace(); // Handle the exception according to your needs
	    }

	    return employees;
	}
}