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

public class UserStoryCreationController {
	//UserStoryDatabase userStoryDatabase = UserStoryDatabase.getInstance();
	//ArrayList<UserStory> userStoryList = userStoryDatabase.getStoryList();
	
	UserStoryDatabase userStoryDatabase = UserStoryDatabase.getInstance();
	ArrayList<UserStory> userStoryList = userStoryDatabase.getStoryList("src/application/UserStoryDatabase.txt");
	
	//
	private Scene userStoryScene;
	private Stage currentStage;
	public int storyCount = 1;
//	
//	//set storyCount variable (Not working fully and will probably change to a loop that checks how many stories are in the database and adds that to the base initialization of 1)
//	void setCount(int newCount) {
//		this.storyCount = newCount;
//		String outcome = Integer.toString(storyCount);
//		storyNumber.setText(outcome);
//	}
//	
//	//returns storyCount
//	public int getCount() {
//		return storyCount;
//	}
//	
//	@FXML
//	public void initialize() {
//    	setCount(storyCount);
//    }
//	
	@FXML
    private Button nextButton;
	
	@FXML
    private Label storyNumber;

    @FXML
    private TextField userStoryDescription;

    @FXML
    private TextField userStoryName;

    @FXML
    void moveToUserStories(ActionEvent event) throws IOException {
    	//Trying to get it to update between pages working **oscar**
    	String storyName = userStoryName.getText().toString();
    	String storyDesc = userStoryDescription.getText().toString();
    	
    	UserStory acStory = new UserStory(" "," ",storyName, storyDesc,0,"null","null","null");

    	userStoryDatabase.addStory(acStory);

    	//System.out.print(userStoryDatabase);
    	
    	UserStoryWriter.writeUserStoriesToFile("src/application/UserStoryDatabase.txt", userStoryList);
    	/// end of my work

    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("testVoting.fxml"));
    	userStoryScene = new Scene(fxmlLoader1.load());
    	currentStage = (Stage) nextButton.getScene().getWindow();
    	currentStage.setScene(userStoryScene);
    }
}

