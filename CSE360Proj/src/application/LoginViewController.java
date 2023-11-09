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
	private Scene scene;
	private Stage stage;
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
    	String username1 = usernameField.getText().toString();
    	String password1 = passwordField.getText().toString();
    	if (usernameTest.equals(username1) && passwordTest.equals(password1)) {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	scene = new Scene(fxmlLoader.load());
    	stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    	}
    	else {
    		passwordPrompt.setVisible(true);
    	}
    }
}
