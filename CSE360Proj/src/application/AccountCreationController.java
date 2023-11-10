package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.control.*;	//imports all javafx.scene.control. functions
import application.Employee;
import application.EmployeeDatabase;

public class AccountCreationController {
	private Scene newscene;
	private Stage currentStage;
	
	EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();
	ArrayList<Employee> employeeList = employeeDatabase.getEmployeeList();
	
	@FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField idField;
    
    @FXML
    private Label errorlabel;
    
    @FXML
    void submitAC (ActionEvent event) throws IOException{
    	
    	String username = usernameField.getText().toString();
    	String password = passwordField.getText().toString();
    	Employee loginEmployee = employeeDatabase.getEmployee(employeeList, username);
    
    	if (loginEmployee!=null && loginEmployee.getPassword().equals(password)) {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
	    	newscene = new Scene(fxmlLoader.load());
	    	currentStage = (Stage) submitButton.getScene().getWindow();
	    	currentStage.setScene(newscene);
    	}
    	else {
    		errorlabel.setVisible(true);
    		passwordField.clear();
    	}
    }
}
