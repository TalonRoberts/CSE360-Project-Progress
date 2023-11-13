package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


//LoginPage FXML Elements



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();
	    	ArrayList<Employee> employeeList = employeeDatabase.loadDatabase(getClass().getResource("/application/employeelist.txt").getPath());
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	
}
