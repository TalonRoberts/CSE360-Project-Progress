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
import javafx.scene.control.Label;

public class ProjectCreationController {
	private Scene ELMainScene;
	private Scene userStoryScene;
	private Stage currentStage;
	
	UserStoryDatabase userStoryDatabase = UserStoryDatabase.getInstance();
	ArrayList<UserStory> userStoryList = userStoryDatabase.getStoryList("src/application/UserStoryDatabase.txt");
	
	@FXML
    private Button nextButton;
	
	@FXML
    private Button backButton;
	
	@FXML
    private Label descriptionError;

    @FXML
    private Label nameError;

    @FXML
    private TextField projectDescription;

    @FXML
    private TextField projectName;
    
    

    @FXML
    void backToELMain(ActionEvent event) throws IOException {
    	//loads main page
    	FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	ELMainScene = new Scene(fxmlLoader2.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(ELMainScene);
    }
    
    @FXML
    void moveToUserStories(ActionEvent event) throws IOException {
    	//checks if description field is empty
    	if(projectDescription.getText().isEmpty() == true) {
    		descriptionError.setVisible(true);
    	}
    	else {
    		descriptionError.setVisible(false);
    	}
    	
    	//checks if name field is empty
    	if(projectName.getText().isEmpty() == true) {
    		nameError.setVisible(true);
    	}
    	else {
    		nameError.setVisible(false);
    	}
    	
    	//checks if neither description or name fields are empty
    	if (projectDescription.getText().isEmpty() == false && projectName.getText().isEmpty() == false){
    		//Code i added that adds a user story to the databse only with 
        	//project name and desc info though
    		String projName = projectName.getText().toString();
    		String projDesc = projectDescription.getText().toString();
    	
    		UserStory acStory = new UserStory(projName,projDesc,"temp");
    		userStoryList.add(acStory);
    	
    	
    		UserStoryWriter.writeUserStoriesToFile("src/application/UserStoryDatabase.txt", userStoryList);
    		//end of my block
    	
    		//loads user story screen
    		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("UserStoryCreation.fxml"));
    		userStoryScene = new Scene(fxmlLoader1.load());
    		currentStage = (Stage) nextButton.getScene().getWindow();
    		currentStage.setScene(userStoryScene);
    	}
    }
}
