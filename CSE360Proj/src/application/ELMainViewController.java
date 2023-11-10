package application;

import java.io.IOException;
import application.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ELMainViewController {
	private Scene loginreturn;
	private Stage currentStage;
	
	@FXML
    private Button effortLogButton;

    @FXML
    private Button historicalDataButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button planningPokerButton;

    @FXML
    void logout(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
    	loginreturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) logoutButton.getScene().getWindow();
    	currentStage.setScene(loginreturn);
    }

    @FXML
    void openEffortLog(ActionEvent event) {

    }

    @FXML
    void openHistoricalData(ActionEvent event) {

    }

    @FXML
    void openPlanningPoker(ActionEvent event) {

    }
}
