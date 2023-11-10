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
    void submitAC (ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void backToLogin (ActionEvent event) throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
    	loginreturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(loginreturn);
    }
}
