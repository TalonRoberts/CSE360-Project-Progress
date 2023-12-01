package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class historicalController {
	EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();
	ArrayList<Employee> employeeList = employeeDatabase.getEmployeeList();
	Employee currentEmployee = employeeDatabase.getCurrentEmployee();
	
	ProjectDatabase projectDatabase = ProjectDatabase.getInstance();
	ArrayList<Project> projectList = projectDatabase.getProjectList();
	
	effortLogsDatabase effortLogDatabase = effortLogsDatabase.getInstance();
	ArrayList<EffortLog> effortLogsListB = effortLogDatabase.getLogList();
	
	UserStoryDatabase storydatabase = UserStoryDatabase.getInstance();
	ArrayList<UserStory> storyList = storydatabase.getList();
	
	
	private Scene mainReturn;
	private Stage currentStage;
	
	@FXML
	private Button backButton;
		
	@FXML
	private Button logs;
	
	@FXML
	private Button projects;
	
	@FXML
	private Button stories;
	
	@FXML
    void back(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	mainReturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(mainReturn);
    }
	
	@FXML
    void goLogs(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EffortDefectLog.fxml"));
    	mainReturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(mainReturn);
    }
	
	@FXML
	void viewStories(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("projstory.fxml"));
    	mainReturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) stories.getScene().getWindow();
    	currentStage.setScene(mainReturn);
	}
}
