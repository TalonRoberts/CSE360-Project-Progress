package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeWriter {

    public static void writeEmployeesToFile(String filePath, ArrayList<Employee> employees) {
        BufferedWriter bw = null; // Declare outside the try block for access in the finally block
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Employee employee : employees) {
                // Format the Employee data as a line in the text file
                String line = employee.getId() + "," + employee.getName() + "," + employee.getPassword();
                bw.write(line);
                bw.newLine(); // Add a new line for the next employee
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing BufferedWriter: " + e.getMessage());
            }
        }
    }
}
