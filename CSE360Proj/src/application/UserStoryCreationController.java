package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserStoryCreationController {
	
	UserStoryDatabase userStoryDatabase = UserStoryDatabase.getInstance();
	ArrayList<UserStory> userStoryList = userStoryDatabase.getStoryList();
	
    @FXML
    private Button nextButton;

    @FXML
    private TextField userStoryDescription;

    @FXML
    private TextField userStoryName;

    @FXML
    void moveToUserStories(ActionEvent event) {
    	
    	//Trying to get it to update between pages not working **oscar**
    	String storyName = userStoryName.getText().toString();
    	String storyDesc = userStoryDescription.getText().toString();
    	
    	UserStory oldStory = UserStoryDatabase.getStory(userStoryList, "temp");

    	
    	
    	UserStory acStory = new UserStory(oldStory.getProjectName(),oldStory.getProjDesc(),
    			storyName, storyDesc, 0,"","","");
    	
    	acStory.setUserStoryName("blue");
    	
    	userStoryList.add(acStory);
    	userStoryList.remove(oldStory);
    	
    	
    	UserStoryWriter.writeUserStoriesToFile("src/application/UserStoryDatabase.txt", userStoryList);
    	/// end of my work
    	
    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("UserStoryCreation.fxml"));
    	newscene1 = new Scene(fxmlLoader1.load());
    	currentStage = (Stage) nextButton.getScene().getWindow();
    	currentStage.setScene(newscene1);
    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("UserStoryCreation.fxml"));
    	newscene1 = new Scene(fxmlLoader1.load());
    	currentStage = (Stage) nextButton.getScene().getWindow();
    	currentStage.setScene(newscene1);
    }
}
