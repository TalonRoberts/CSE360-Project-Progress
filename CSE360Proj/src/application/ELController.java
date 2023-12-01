package application;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.collections.*;

public class ELController {
	EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();
	ArrayList<Employee> employeeList = employeeDatabase.getEmployeeList();
	Employee currentEmployee = employeeDatabase.getCurrentEmployee();
	
	ProjectDatabase projectDatabase = ProjectDatabase.getInstance();
	ArrayList<Project> projectList = projectDatabase.getProjectList();
	
	effortLogsDatabase effortLogDatabase = effortLogsDatabase.getInstance();
	ArrayList<EffortLog> effortLogsListB = effortLogDatabase.getLogList();

	
	private Scene mainReturn;
	private Stage currentStage;
	
	private long displayMinutes;
	private long startTime;
	private long secondspassed;
	private long timepassed;
	private long displaySeconds;
	private long startTotal;
	private int startMin;
	private int startSec;
	private int startHour;
	
	private boolean clockRunning = false;
	
	private Project selectedProject;
	private String selectedEffort;
	
	private ObservableList<String> businessLCS = FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Veryifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting");
	private ObservableList<String> devLCS = FXCollections.observableArrayList("Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review", "Detailed Design Plan", "Detailed Design/Prototype", "Detailed Design Review", "Implementation Plan", "Test Case Generation", "Solution Specification", "Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update");
	private ObservableList<String> plansEC = FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan", "Implementation Plan");
	private ObservableList<String> deliverablesEC = FXCollections.observableArrayList("Conceptual Design","Detailed Design", "Test Cases", "Solution", "Reflection", "Outline", "Draft", "Report", "User Defined", "Other");
	private ObservableList<String> interruptionsEC = FXCollections.observableArrayList("Break", "Phone", "Teammate", "Visitor", "Other");
	
	@FXML
	private Button startButton;
	
	@FXML
	private Button stopButton;
	
	@FXML
	private ComboBox<String> projectCB;
	
	@FXML
	private ComboBox<String> lifeCycleStepCB;
	
	@FXML
	private ComboBox<String> effortCategoryCB;
	
	@FXML
	private ComboBox<String> effortCategoryCB2;
	
	@FXML
	private Button editorButton;
	
	@FXML
	private Button defectButton;
	
	@FXML
	private Button definitionsButton;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Rectangle clockRectangle;
	
	@FXML
	private Label clockLabel;
	
	@FXML
	private Label statusLabel;
	
	
	
	@FXML
	public void initialize() {
	    // Add projects to Database
	    

	    // Populate projectComboBox
	    ObservableList<String> projectNames = FXCollections.observableArrayList();
	    for (Project project : projectList) {
	        projectNames.add(project.getName());
	    }
	    projectCB.setItems(projectNames);

	    // Set an event handler for the projectComboBox selection
	    projectCB.setOnAction(event -> {
	        selectedProject = projectDatabase.getProject(projectList, projectCB.getValue());
	        updateLifeCycleSteps();
	    });
	    
	    ObservableList<String> effortList1 = FXCollections.observableArrayList("Plans","Deliverables", "Interruptions");
	    effortCategoryCB.setItems(effortList1);
	    
	    effortCategoryCB.setOnAction(event -> {
	    	selectedEffort = effortCategoryCB.getValue();
	    	updateEffortCategory();
	    });
	    
	}

	// Method to update lifeCycleStepCB based on the selected project type
	private void updateLifeCycleSteps() {
	    if (selectedProject != null) {
	        if (selectedProject.getType().equals("Business Project")) {
	            lifeCycleStepCB.setItems(businessLCS);
	        } else if (selectedProject.getType().equals("Development Project")) {
	            lifeCycleStepCB.setItems(devLCS);
	        }
	    }
	}
	
	private void updateEffortCategory() {
		if (selectedEffort != null) {
			if (selectedEffort.equals("Plans")) {
				effortCategoryCB2.setItems(plansEC);
			}
			else if (selectedEffort.equals("Deliverables")) {
				effortCategoryCB2.setItems(deliverablesEC);
			}
			else if(selectedEffort.equals("Interruptions")) {
				effortCategoryCB2.setItems(interruptionsEC);
			}
		}
	}
	
	@FXML
    void back(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ELMainPage.fxml"));
    	mainReturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) backButton.getScene().getWindow();
    	currentStage.setScene(mainReturn);
    }
	
	@FXML
    void toLogs(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EffortDefectLog.fxml"));
    	mainReturn = new Scene(fxmlLoader.load());
    	currentStage = (Stage) definitionsButton.getScene().getWindow();
    	currentStage.setScene(mainReturn);
    }
	
	@FXML
	void startActivity(ActionEvent event) throws IOException, InterruptedException {
		if (clockRunning == false) {
			statusLabel.setVisible(false);
			displayMinutes = 0;
			startTime = System.currentTimeMillis();
			clockRectangle.setFill(Color.GREEN);
			clockLabel.setText("Clock is running");
			clockRunning = true;
		}
		else if (clockRunning == true) {
			statusLabel.setVisible(true);
			statusLabel.setTextFill(Color.RED);
			statusLabel.setText("Error: Activity already in progress");
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					statusLabel.setVisible(false);
				}
			};
			timer.schedule(task, 5000);
		}
	}
	
	@FXML
	void stopActivity(ActionEvent event) throws IOException {
		if (clockRunning == false) {
			
			statusLabel.setVisible(true);
			statusLabel.setTextFill(Color.RED);
			statusLabel.setText("Error: No activity in progress");
			Timer timer2 = new Timer();
			TimerTask task2 = new TimerTask() {
				@Override
				public void run() {
					statusLabel.setVisible(false);
				}
			};
			timer2.schedule(task2, 5000);
		}
		if (clockRunning == true) {
			if (projectCB.getSelectionModel().isEmpty() || lifeCycleStepCB.getSelectionModel().isEmpty() || effortCategoryCB.getSelectionModel().isEmpty() || effortCategoryCB2.getSelectionModel().isEmpty()) {
				statusLabel.setVisible(true);
				statusLabel.setTextFill(Color.RED);
				statusLabel.setText("Error: Activity details incomplete");
				Timer timer3 = new Timer();
				TimerTask task3 = new TimerTask() {
					@Override
					public void run() {
						statusLabel.setVisible(false);
					}
				};
				timer3.schedule(task3, 5000);
			}
			else {
				// set Rectangle 
				clockLabel.setText("Clock stopped");
				clockRectangle.setFill(Color.RED);
				//delta time
				timepassed = System.currentTimeMillis() - startTime;
				secondspassed = timepassed/1000;
				displayMinutes = (int)secondspassed/60;
				displaySeconds = (int)secondspassed%60;
				String formattedDeltaTime = String.format("%02d:%02d",displayMinutes,displaySeconds);
				System.out.println(formattedDeltaTime);
				// date
				LocalDate currentDate = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String formattedDate = currentDate.format(formatter);
				// startTime
				startTotal = startTime / 1000;
				startHour = (int) ((startTotal / 3600) % 24) + 17;
				startMin = (int) (startTotal % 3600) / 60;
				startSec = (int) startTotal % 60;
				
				String formattedStartTime = String.format("%02d:%02d:%02d", startHour,startMin, startSec);
				System.out.println(formattedStartTime);
				
				Long endTime = System.currentTimeMillis();
				startTotal = endTime / 1000;
				startHour = (int) ((startTotal / 3600) % 24) + 17;
				startMin = (int) (startTotal % 3600) / 60;
				startSec = (int) startTotal % 60;
				String formattedendTime = String.format("%02d:%02d:%02d", startHour,startMin, startSec);
				System.out.println(formattedendTime);
				
				// Make new EffortLog
				EffortLog newLog = new EffortLog(projectCB.getValue(), Integer.toString(currentEmployee.getId()), formattedDate, formattedStartTime, formattedendTime, formattedDeltaTime, lifeCycleStepCB.getValue(), effortCategoryCB.getValue(), effortCategoryCB2.getValue());
				System.out.println(newLog.toString());
				
				effortLogDatabase.addLog(newLog);
				
				statusLabel.setVisible(true);
				statusLabel.setTextFill(Color.GREEN);
				statusLabel.setText("Effort Logged!");
				Timer timer4 = new Timer();
				TimerTask task4 = new TimerTask() {
					@Override
					public void run() {
						statusLabel.setVisible(false);
					}
				};
				timer4.schedule(task4, 5000);
				
				clockRunning = false;
			}
		}
	}
	
}
