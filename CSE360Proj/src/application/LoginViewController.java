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





public class LoginViewController{
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
    private Label errorlabel;
    
    @FXML
    private Button NUButton;

    @FXML
    void submitLogin(ActionEvent event) throws IOException {
    	String username = usernameField.getText().toString();
    	String password = passwordField.getText().toString();
    	Employee loginEmployee = employeeDatabase.getEmployee(employeeList, username);
    
    	if (loginEmployee!=null && loginEmployee.getPassword().equals(password)) {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
	    	newscene = new Scene(fxmlLoader.load());
	    	currentStage = (Stage) submitButton.getScene().getWindow();
	    	currentStage.setScene(newscene);
    	}
    	else if(loginEmployee==null){
    		errorlabel.setText("User Does Not Exits");
    		errorlabel.setVisible(true);
    		passwordField.clear();
    	}
    	else {
    		errorlabel.setText("Username/Password Error");
    		errorlabel.setVisible(true);
    		passwordField.clear();
    	}
    }
    
    @FXML
    void switchToAC(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountCreation.fxml"));
    	newscene = new Scene(fxmlLoader.load());
    	currentStage = (Stage) NUButton.getScene().getWindow();
    	currentStage.setScene(newscene);
    }
}
