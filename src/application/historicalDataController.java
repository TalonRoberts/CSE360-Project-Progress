package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class historicalDataController {
	private Scene ELMainScene;
	private Stage currentStage;
	
	@FXML
    private Button backButton;

    @FXML
    private ComboBox<?> keyWord;

    @FXML
    void backToMainPage(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	ELMainScene = new Scene(fxmlLoader2.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(ELMainScene);
    }
}
