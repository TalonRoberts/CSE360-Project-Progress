package application;

import javafx.scene.control.Label;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.voteOutcomeController;

public class testVotingController<Int> {

	private Scene voteAssessmentScene;
	private Stage currentStage;
	
	public int voteOutcome = 0;		//Variable that will store the final outcome of the vote
	public double weightedAverageValue; 	//Variable that will store average of all votes if an agreement is not reached
	
	int voteValue1;		//Will hold value selected in comboBox1
	int voteValue2;		//Will hold value selected in comboBox2	
	int voteValue3;		//Will hold value selected in comboBox3
	int voteValue4;		//Will hold value selected in comboBox4
    @FXML
    private Button nextButton;
    
    @FXML
    private Label errorLabel;
    
    @FXML
    private Label weightedAverageLabel;
	
	@FXML
    private ComboBox<Integer> voteComboBox1;

    @FXML
    private ComboBox<Integer> voteComboBox2;

    @FXML
    private ComboBox<Integer> voteComboBox3;

    @FXML
    private ComboBox<Integer> voteComboBox4;
    
    @FXML
    private TextField voteDescription1;

    @FXML
    private TextField voteDescription2;

    @FXML
    private TextField voteDescription3;

    @FXML
    private TextField voteDescription4;
    
    public void initialize() {
    	//sets comboBox contents
    	ObservableList<Integer> voteOptions = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
    	voteComboBox1.setItems(voteOptions);	//sets options for comboBox 1
    	voteComboBox1.setValue(1);				//sets default value of 1 for comboBox so a value must be selected
    	voteComboBox2.setItems(voteOptions);	//"
    	voteComboBox2.setValue(1);				//"
    	voteComboBox3.setItems(voteOptions);
    	voteComboBox3.setValue(1);
    	voteComboBox4.setItems(voteOptions);
    	voteComboBox4.setValue(1);
    }
    
    @FXML
    void moveToVoteAssessment(ActionEvent event) throws IOException{
    	//sets an integer variables voteValue1-4 to value selected in each comboBox
    	voteValue1 = voteComboBox1.getValue();	
    	voteValue2 = voteComboBox2.getValue();
    	voteValue3 = voteComboBox3.getValue();
    	voteValue4 = voteComboBox4.getValue();
    	//checks if vote values are within 1
    	if((Math.abs(voteValue1 - voteValue2) <= 1) && (Math.abs(voteValue1 - voteValue3) <= 1) && (Math.abs(voteValue1 - voteValue4) <= 1) && (Math.abs(voteValue2 - voteValue3) <= 1) && (Math.abs(voteValue2 - voteValue4) <= 1) && (Math.abs(voteValue3 - voteValue4) <= 1)) {
        	int temp1 = Math.max(voteValue2, voteValue1);
        	int temp2 = Math.max(voteValue3, voteValue4);
        	voteOutcome = Math.max(temp1, temp2);	//sets voteOutcome to higher value
        	errorLabel.setVisible(false);
        	
        	//code to mode to voting assessment page
        	FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("VoteOutcome.fxml"));
        	Parent root = fxmlLoader1.load();
        	//vote outcome loader
        	voteOutcomeController outcome = (voteOutcomeController)fxmlLoader1.getController();
        	outcome.setVoteOutcome(voteOutcome);
        	//fxmlLoader1.setController(outcome);
        	voteAssessmentScene = new Scene(root);
        	currentStage = (Stage) nextButton.getScene().getWindow();
        	currentStage.setScene(voteAssessmentScene);
        	
        }
    	else {
    		//Calculates and sets weighted average and makes it visible to user
    		weightedAverageValue = (((double)(voteValue1 + voteValue2 + voteValue3 + voteValue4)) / 4);	
    		weightedAverageLabel.setText(Double.toString(weightedAverageValue));
    		errorLabel.setVisible(true);
    		}
    		/* Code used for opening separate screen when the votes are not within 1. 
    		 * Removing and changing to an error message on the same screen
    		 * 
    		 * 
    		FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("voteAssessment.fxml"));
    		Parent root1 = fxmlLoader2.load();
    		//weighted average loader
    		voteAssessmentController weightedAverage = (voteAssessmentController)fxmlLoader2.getController();
    		weightedAverage.setWeightedAverage(weightedAverageValue);
    		System.out.println(weightedAverageValue);
    		
    		//vote 1 loader
    		voteAssessmentController vote1 = (voteAssessmentController)fxmlLoader2.getController();
        	vote1.setVote1(voteValue1);
        	
        	//vote 2 loader
    		voteAssessmentController vote2 = (voteAssessmentController)fxmlLoader2.getController();
        	vote2.setVote2(voteValue2);
        	
        	//vote 3 loader
    		voteAssessmentController vote3 = (voteAssessmentController)fxmlLoader2.getController();
        	vote3.setVote3(voteValue3);
        	
        	//vote 4 loader
    		voteAssessmentController vote4 = (voteAssessmentController)fxmlLoader2.getController();
        	vote4.setVote4(voteValue4);
        	
    		//description 1 loader
    		voteAssessmentController description1 = (voteAssessmentController)fxmlLoader2.getController();
    		//String desc1 = voteDescription1.getText().toString();
    		description1.setDesc1(voteDescription1);
    		
    		//description 2 loader
    		voteAssessmentController description2 = (voteAssessmentController)fxmlLoader2.getController();
    		description2.setDesc2(voteDescription2);
    		
    		//description 3 loader
    		voteAssessmentController description3 = (voteAssessmentController)fxmlLoader2.getController();
    		description3.setDesc3(voteDescription3);
    		
    		//description 4 loader
    		voteAssessmentController description4 = (voteAssessmentController)fxmlLoader2.getController();
    		description4.setDesc4(voteDescription4);
    		
    		voteAssessmentScene2 = new Scene(root1);
    		currentStage = (Stage) nextButton.getScene().getWindow();
    		currentStage.setScene(voteAssessmentScene2);
    		*/
    	}
    }