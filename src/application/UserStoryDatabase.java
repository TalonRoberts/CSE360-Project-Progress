package application;

import java.util.ArrayList;
import application.UserStory;
import application.EmployeeReader;

public class UserStoryDatabase {
	private static UserStoryDatabase instance;
	private ArrayList<UserStory> userStoryList;
	private UserStory currentStory;
	
	private UserStoryDatabase() {
		userStoryList = new ArrayList<>();
	}
	
	public static UserStoryDatabase getInstance() {
		if (instance == null) {
			instance = new UserStoryDatabase();
		}
		return instance;
	}
	
	public ArrayList<UserStory> loadDatabase(String filename) {
		userStoryList = UserStoryReader.readUserStoriesFromFile(filename);
		return userStoryList;
	}
	
	public void addStory(UserStory story) {
		userStoryList.add(story);
	}
	
	public void remove(UserStory story) {
		userStoryList.remove(story);
	}
	
	public ArrayList<UserStory> getStoryList() {
		return userStoryList;
	}
	
	 public static UserStory getStory(ArrayList<UserStory> list, String storyName) {
 		for (UserStory story: list) {
 			if (story.getStoryName().equals(storyName)) {
 				System.out.print("found");
 				return story;
 			}
 		}
 		return null;
 	}

	// public Employee getEmployee(ArrayList<Employee> list, int id) {
// 		for (Employee employee: list) {
// 			if (employee.getId() == id) {
// 				return employee;
// 			}
// 		}
// 		return null;
// 	}

	public void setCurrentStory(UserStory story){
		currentStory = story;
	}
	public UserStory getCurrentStory() {
		return currentStory;
	}
}