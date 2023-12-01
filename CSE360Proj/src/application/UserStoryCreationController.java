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
	
	private Scene votingScene;
	private Stage currentStage;
	public static int storyCount = 0;
	
	//set storyCount variable (Not working fully and will probably change to a loop that checks how many stories are in the database and adds that to the base initialization of 1)
	/*void setCount(int newCount) {
		this.storyCount = newCount;
		String outcome = Integer.toString(storyCount);
		storyNumber.setText(outcome);
	}
	
	void storyCountIncrementer(int storyCount) {
		
	}
	
	//returns storyCount
	public int getCount() {
		return storyCount;
	} */
	
public void initialize() {
	storyCount++;	//increments the story count by 1
	String outcome = Integer.toString(storyCount);	//creating a string variable for storyCount
	storyNumber.setText(outcome);	//Setting label to storyCount
    }
	
	@FXML
    private Button nextButton;
	
	@FXML
    private Label storyNumber;
	
	@FXML
    private Label descriptionError;

    @FXML
    private Label nameError;

    @FXML
    private TextField userStoryDescription;

    @FXML
    private TextField userStoryName;

    @FXML
    void moveToVoting(ActionEvent event) throws IOException {
    	//checks if description field is empty
    	if(userStoryDescription.getText().isEmpty() == true) {
    		descriptionError.setVisible(true);
    	}
    	else {
    		descriptionError.setVisible(false);
    	}
    	//checks if name field is empty
    	if(userStoryName.getText().isEmpty() == true) {
    		nameError.setVisible(true);
    	}
    	else {
    		nameError.setVisible(false);
    	}
    	//if neither name or description field is empty
    	if (userStoryDescription.getText().isEmpty() == false && userStoryName.getText().isEmpty() == false){
    	
    	//Trying to get it to update between pages not working **oscar**
    	String storyName = userStoryName.getText().toString();
    	String storyDesc = userStoryDescription.getText().toString();
    	
    	//UserStory oldStory = UserStoryDatabase.getStory(userStoryList, "temp");

    	
    	
    	//UserStory acStory = new UserStory(oldStory.getProjectName(),oldStory.getProjDesc(),
    			//storyName, storyDesc, 0,"","","");
    	UserStory acStory = new UserStory(" "," ",
    			storyName, storyDesc, 0,"","","");
    	
    	//acStory.setUserStoryName(storyName);
    	
    	userStoryList.add(acStory);
    	//userStoryList.remove(oldStory);
    	
    	
    	UserStoryWriter.writeUserStoriesToFile("src/application/UserStoryDatabase.txt", userStoryList);
    	/// end of my work

    	//loads voting screen
    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("testVoting.fxml"));
    	votingScene = new Scene(fxmlLoader1.load());
    	currentStage = (Stage) nextButton.getScene().getWindow();
    	currentStage.setScene(votingScene);
    	}
    }
}

