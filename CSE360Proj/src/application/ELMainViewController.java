package application;

import java.io.IOException;
import java.util.ArrayList;
import application.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import application.EmployeeDatabase;
import application.Employee;
import javafx.scene.control.Label;


public class ELMainViewController {
	private Scene loginreturn;
	private Scene newscene1;
	private Stage currentStage;
	
	
	EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();
	ArrayList<Employee> employeeList = employeeDatabase.getEmployeeList();
	
	private Employee currentEmployee = employeeDatabase.getCurrentEmployee();
	
	@FXML
    private Button effortLogButton;

    @FXML
    private Button historicalDataButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button planningPokerButton;
    
    @FXML
    private Label employeeLabel;
    
    @FXML
    private Button infoButton;

    @FXML
    void logout(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
    	loginreturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) logoutButton.getScene().getWindow();
    	currentStage.setScene(loginreturn);
    }

    @FXML
    void openEffortLog(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EffortLogger.fxml"));
    	loginreturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) logoutButton.getScene().getWindow();
    	currentStage.setScene(loginreturn);
    }

    @FXML
    void openHistoricalData(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("historical.fxml"));
    	loginreturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) logoutButton.getScene().getWindow();
    	currentStage.setScene(loginreturn);
    }

    @FXML
    void openPlanningPoker(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("ProjectCreation.fxml"));
    	newscene1 = new Scene(fxmlLoader1.load());
    	currentStage = (Stage) planningPokerButton.getScene().getWindow();
    	currentStage.setScene(newscene1);
    }
    
    @FXML
    void showInfo(ActionEvent event) {
    	if (infoButton.getText().equals("Show User Info")) {
    		employeeLabel.setText("Id: " + currentEmployee.getId() + "  " + "User: " + currentEmployee.getName());
    		infoButton.setText("Hide User Info");
    	}
    	else if (infoButton.getText().equals("Hide User Info")) {
    		employeeLabel.setText("");
    		infoButton.setText("Show User Info");
    	}
    }
}
