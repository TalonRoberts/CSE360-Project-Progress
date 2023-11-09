package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.control.*;	//imports all javafx.scene.control. functions
import javafx.scene.control.Alert.AlertType;


public class LoginViewController {
	private Scene newscene;
	private Stage currentStage;
	public String usernameTest = "usertest";
	public String passwordTest = "passtest";
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private VBox passwordPrompt;

    @FXML
    private Button submitButton;

    @FXML
    private TextField usernameField;

    @FXML
    void submitLogin(ActionEvent event) throws IOException {
    	String username = usernameField.getText().toString();
    	String password = passwordField.getText().toString();
    	if (usernameTest.equals(username) && passwordTest.equals(password)) {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	newscene = new Scene(fxmlLoader.load());
    	currentStage = (Stage) submitButton.getScene().getWindow();
    	currentStage.setScene(newscene);
    	}
    	else {
    		passwordPrompt.setVisible(true);
    	}
    }
}
