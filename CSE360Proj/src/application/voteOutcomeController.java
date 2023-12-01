package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import application.testVotingController;	//importing testVotingController to use getVoteOutcome

public class voteOutcomeController {
	private Scene userStoryScene;
	private Scene ELMainScene;
	private Stage currentStage;
	int intOutcome;
	int countIncrement;
	
	//setting voteOutcoeValue label to inputed integer
	 void setVoteOutcome(int intOutcome) {
		this.intOutcome = intOutcome;
		String outcome = Integer.toString(intOutcome);
		voteOutcomeValue.setText(outcome);
	}
	
	
	
	
	
	@FXML
    private Button addUserStory;

    @FXML
    private Button finishPP;

    @FXML
    private Label voteOutcomeValue;

    public void initialize() {
    	
    }
    
    @FXML
    void toAddUserStory(ActionEvent event) throws IOException {
    	//Loads user story scene
    	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("UserStoryCreation.fxml"));
    	Parent root = fxmlLoader1.load();
		userStoryScene = new Scene(root);
    	currentStage = (Stage) addUserStory.getScene().getWindow();
    	currentStage.setScene(userStoryScene);
    }

    @FXML
    void toEffortLoggerMain(ActionEvent event) throws IOException {
    	//Ends Planning Poker and loads main page
    	FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	Parent root = fxmlLoader2.load();
    	ELMainScene = new Scene(root);
    	currentStage = (Stage) addUserStory.getScene().getWindow();
    	currentStage.setScene(ELMainScene);
    }
}