package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.control.*;	//imports all javafx.scene.control. functions
import application.Employee;
import application.EmployeeDatabase;
import javafx.scene.paint.Color;

public class AccountCreationController {
	private Scene loginreturn;
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
    private Label newUserButton;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Label acLabel;
    
    @FXML
    void submitAC (ActionEvent event) throws IOException{
    	String username = usernameField.getText().toString();
    	String password = passwordField.getText().toString();
    	int id = Integer.parseInt(idField.getText());
    	Employee acEmployee = employeeDatabase.getEmployee(employeeList, id);
    	if (acEmployee != null && acEmployee.getName().equals(username) && acEmployee.getPassword().equals("NOPASS") && password.length() > 3){
    		acEmployee.setPassword(password);
    		
    		EmployeeWriter.writeEmployeesToFile(getClass().getResource("/application/employeelist.txt").getPath(), employeeList);
    		
    		errorlabel.setVisible(false);
    		acLabel.setVisible(true);
    		passwordField.clear();
			idField.clear();
			usernameField.clear();
    	}
    	else if(acEmployee == null || !acEmployee.getName().equals(username) || !acEmployee.getPassword().equals("NOPASS")) {
    		errorlabel.setText("Invalid ID/Username");
    		errorlabel.setTextFill(Color.RED);
    		acLabel.setVisible(false);
    		errorlabel.setVisible(true);
    		passwordField.clear();
    		idField.clear();
    		usernameField.clear();
    	}
    	else if(password.length() < 13 || password.length() > 256) {
    		errorlabel.setText("Invalid Password");
			errorlabel.setTextFill(Color.RED);
			acLabel.setVisible(false);
			errorlabel.setVisible(true);
			passwordField.clear();
			idField.clear();
			usernameField.clear();
    	}
    }
    @FXML
    void backToLogin (ActionEvent event) throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
    	loginreturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(loginreturn);
    }
}
