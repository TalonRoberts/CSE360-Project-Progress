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
	ArrayList<UserStory> userStoryList = userStoryDatabase.getStoryList("src/application/UserStoryDatabase.txt");
	
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
    	
    	UserStory acStory = UserStoryDatabase.getStory(userStoryList, "temp");

    	
    	acStory.setUserStoryName(storyName);
    	acStory.setUserStoryDesc(storyDesc);

    	
    	
    	UserStoryWriter.writeUserStoriesToFile("src/application/UserStoryDatabase.txt", userStoryList);
    	/// end of my work
    	
    	
    }
}
