package application;
import java.util.ArrayList;
import application.UserStory;
import application.EmployeeReader;

public class UserStoryDatabase {
	private static UserStoryDatabase instance;
	private static ArrayList<UserStory> userStoryList;
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
	
	public void loadDatabase(String filename) {
		userStoryList = UserStoryReader.readUserStoriesFromFile(filename);
	}
	
	public void addStory(UserStory story) {
		userStoryList.add(story);
	}
	
	public void remove(UserStory story) {
		userStoryList.remove(story);
	}
	
	public ArrayList<UserStory> getStoryList(String filePath) {
		loadDatabase(filePath);
		return userStoryList;
	}
	
	 public static UserStory getStory(ArrayList<UserStory> list, String storyName) {
 		for (UserStory story: list) {
 			if (story.getStoryName().equals(storyName)) {
 				//System.out.print("found");
 				return story;
 			}
 		}
 		return null;
 	}

	 public String toString() {
		String str = "";
 		for (UserStory story: userStoryList) {
 			str += story.getStoryName();
 			str+= "\n";
 		}
 		return str;
 	}

	public void setCurrentStory(UserStory story){
		currentStory = story;
	}
	public UserStory getCurrentStory() {
		return currentStory;
	}
}
