//author: Angel Ibarra Duran
//group: Th59

//package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PokerSession extends Application {

	  private String loggedInUser;
	    private String createdSessionTitle;

	    @Override
	    public void start(Stage primaryStage) {
	        primaryStage.setTitle("Planning Poker");

	        // Login Scene
	        Scene loginScene = createLoginScene(primaryStage);

	        primaryStage.setScene(loginScene);
	        primaryStage.show();
	    }

	    private Scene createLoginScene(Stage primaryStage) {
	        VBox loginLayout = new VBox(10);
	        loginLayout.setPadding(new Insets(20));

	        Label loginLabel = new Label("Login to Planning Poker");
	        TextField usernameField = new TextField();
	        PasswordField passwordField = new PasswordField();
	        Button loginButton = new Button("Login");

	        loginButton.setOnAction(event -> {
	            // Simulating user authentication (replace with actual authentication logic)
	            if ("Angel".equals(usernameField.getText()) && "Th59".equals(passwordField.getText())) {
	                loggedInUser = usernameField.getText();
	                primaryStage.setScene(createCreateSessionScene(primaryStage));
	            } else {
	                showAlert("Invalid credentials");
	            }
	        });

	        loginLayout.getChildren().addAll(loginLabel, new Label("Username:"), usernameField,
	                new Label("Password:"), passwordField, loginButton);

	        return new Scene(loginLayout, 300, 200);
	    }
	    
	    private Scene createCreateSessionScene(Stage primaryStage) {
	        VBox createSessionLayout = new VBox(10);
	        createSessionLayout.setPadding(new Insets(20));

	        Label titleLabel = new Label("Session Title:");
	        TextField titleField = new TextField();
	        Label descriptionLabel = new Label("Session Description:");
	        TextArea descriptionArea = new TextArea();
	        Button createSessionButton = new Button("Create Session");

	        createSessionButton.setOnAction(event -> {
	            // Simulating session creation (replace with actual session creation logic)
	            if (!titleField.getText().isEmpty()) {
	                createdSessionTitle = titleField.getText();
	                primaryStage.setScene(createPlanningPokerScene(primaryStage));
	            } else {
	                showAlert("Please enter a title for the session");
	            }
	        });

	        createSessionLayout.getChildren().addAll(titleLabel, titleField, descriptionLabel, descriptionArea, createSessionButton);

	        return new Scene(createSessionLayout, 400, 300);
	    }

	    private Scene createPlanningPokerScene(Stage primaryStage) {
	        BorderPane pokerLayout = new BorderPane();
	        pokerLayout.setPadding(new Insets(20));

	        Label pokerLabel = new Label("Planning Poker Cards for Session: " + createdSessionTitle);
	        pokerLayout.setCenter(pokerLabel);

	        return new Scene(pokerLayout, 600, 400);
	    }

	    private void showAlert(String message) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.showAndWait();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
