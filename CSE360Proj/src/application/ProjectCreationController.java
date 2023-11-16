package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProjectCreationController {
	private Scene newscene1;
	private Stage currentStage;
	
	UserStoryDatabase userStoryDatabase = UserStoryDatabase.getInstance();
	ArrayList<UserStory> userStoryList = userStoryDatabase.getStoryList("src/application/UserStoryDatabase.txt");
	
	@FXML
    private Button nextButton;

    @FXML
    private TextField projectDescription;

    @FXML
    private TextField projectName;

    @FXML
    void moveToUserStories(ActionEvent event) throws IOException {
    	//Code i added that adds a user story to the databse only with 
    	//project name and desc info though
    	String projName = projectName.getText().toString();
    	String projDesc = projectDescription.getText().toString();
    	
    	UserStory acStory = new UserStory(projName,projDesc,"temp");

    	userStoryDatabase.addStory(acStory);

    	//System.out.print(userStoryDatabase);
    	
    	UserStoryWriter.writeUserStoriesToFile("src/application/UserStoryDatabase.txt", userStoryList);
    	//end of my block
    	
    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("UserStoryCreation.fxml"));
    	newscene1 = new Scene(fxmlLoader1.load());
    	currentStage = (Stage) nextButton.getScene().getWindow();
    	currentStage.setScene(newscene1);
    }
}
