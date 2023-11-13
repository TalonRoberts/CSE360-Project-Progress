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
	//private static final FXMLLoader  = null;
	private Scene loginreturn;
	private Scene projectCreationScene;
	private Stage currentStage;
	private Scene historicalDataScene;
	
	
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
    void openEffortLog(ActionEvent event) {
    	
    }

    @FXML
    void openHistoricalData(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("historicalDataPage.fxml"));
    	historicalDataScene = new Scene(fxmlLoader2.load());
    	currentStage = (Stage) planningPokerButton.getScene().getWindow();
    	currentStage.setScene(historicalDataScene);
    }

    @FXML
    void openPlanningPoker(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("ProjectCreation.fxml"));
    	projectCreationScene = new Scene(fxmlLoader1.load());
    	currentStage = (Stage) planningPokerButton.getScene().getWindow();
    	currentStage.setScene(projectCreationScene);
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
