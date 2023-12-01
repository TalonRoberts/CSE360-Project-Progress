package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.*;
import application.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import application.EmployeeDatabase;
import application.Employee;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.collections.*;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.StringProperty;

public class EffortDefectLogController {
	EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();
	ArrayList<Employee> employeeList = employeeDatabase.getEmployeeList();
	Employee currentEmployee = employeeDatabase.getCurrentEmployee();
	
	ProjectDatabase projectDatabase = ProjectDatabase.getInstance();
	ArrayList<Project> projectList = projectDatabase.getProjectList();
	
	effortLogsDatabase effortLogDatabase = effortLogsDatabase.getInstance();
	ArrayList<EffortLog> effortLogsList = effortLogDatabase.getLogList();
	ArrayList<EffortLog> currentLogList = new ArrayList<>();
	
	private Scene mainReturn;
	private Stage currentStage;
	
	@FXML
	private TableView<EffortLog> ELTable;
	
	@FXML
	private TableColumn<EffortLog, String> employeeColumn;
	
	@FXML
	private TableColumn<EffortLog, String> dateColumn;
	
	@FXML
	private TableColumn<EffortLog, String> startColumn;
	
	@FXML
	private TableColumn<EffortLog, String> stopColumn;
	
	@FXML
	private TableColumn<EffortLog, String> deltaColumn;
	
	@FXML
	private TableColumn<EffortLog, String> LCSColumn;
	
	@FXML
	private TableColumn<EffortLog, String> categoryColumn;
	
	@FXML
	private TableColumn<EffortLog, String> specificsColumn;
	
	@FXML
	private Button backButton;
	
	@FXML
	private ComboBox<String> projectComboBox;
	
	@FXML
	public void initialize() {
		// Populate projectComboBox
	    ObservableList<String> projectNames = FXCollections.observableArrayList();
	    for (Project project : projectList) {
	        projectNames.add(project.getName());
	    }
	    projectComboBox.setItems(projectNames);
		
	    projectComboBox.setOnAction(event -> {
	    	ELTable.getItems().clear();
    		currentLogList.clear();
	    	for (EffortLog effortLog: effortLogsList) {
	    		if(effortLog.getProjectName().equals(projectComboBox.getValue())) {
	    			currentLogList.add(effortLog);
	    		}
	    	}
	    	ObservableList<EffortLog> observableEffortLogs = FXCollections.observableArrayList(currentLogList);
    		ELTable.setItems(observableEffortLogs);
    		employeeColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    		startColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
    		stopColumn.setCellValueFactory(new PropertyValueFactory<>("stop"));
    		deltaColumn.setCellValueFactory(new PropertyValueFactory<>("delta"));
    		LCSColumn.setCellValueFactory(new PropertyValueFactory<>("lcs"));
    		categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    		specificsColumn.setCellValueFactory(new PropertyValueFactory<>("specifics"));
	    });
	    
	}
	public void clearColumn(TableColumn<EffortLog, ?> column) {
		// Get the underlying ObservableList
	    ObservableList<EffortLog> data = ELTable.getItems();

	    // Clear the data in the specific column
	    for (EffortLog item : data) {
	        // Assuming the property you want to clear is an ObservableValue<String>
	        ObservableValue<?> observableValue = column.getCellObservableValue(item);

	        if (observableValue instanceof StringProperty) {
	            // If it's a StringProperty, set its value to null
	            ((StringProperty) observableValue).setValue(null);
	        }
	    }

	    // Refresh the TableView to reflect the changes
	    ELTable.refresh();
	}
	
	@FXML
    void back(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	mainReturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(mainReturn);
    }
	
}
