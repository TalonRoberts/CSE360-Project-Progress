package application;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class projstoryController {
	EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();
	ArrayList<Employee> employeeList = employeeDatabase.getEmployeeList();
	Employee currentEmployee = employeeDatabase.getCurrentEmployee();
	
	ProjectDatabase projectDatabase = ProjectDatabase.getInstance();
	ArrayList<Project> projectList = projectDatabase.getProjectList();
	
	effortLogsDatabase effortLogDatabase = effortLogsDatabase.getInstance();
	ArrayList<EffortLog> effortLogsListB = effortLogDatabase.getLogList();
	
	UserStoryDatabase userStoryDatabase = UserStoryDatabase.getInstance();
	ArrayList<UserStory> userStoryList = userStoryDatabase.getStoryList("src/application/UserStoryDatabase.txt");
	
	private Scene mainReturn;
	private Stage currentStage;
	
	@FXML
	private TextArea storyTF;
	
	@FXML
	private Button backButton;
	
	public void initialize() {
		storyTF.setEditable(false);
		storyTF.setText("");
		for (UserStory story: userStoryList) {
			storyTF.appendText("Project: " + story.getProjectName() +"\nProject Desc: " + story.getProjDesc() + "\n User Story Name: " + story.getStoryName() + "\n User Story: " + story.getStory() + "\n\n");
		}
	}
	
	@FXML
    void back(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	mainReturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(mainReturn);
    }
}
