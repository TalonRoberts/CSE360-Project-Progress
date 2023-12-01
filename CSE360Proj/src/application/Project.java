package application;

import java.util.ArrayList;

public class Project {
	private String projectType;
	private String projectName;
	private String projectDescription;
	private ArrayList<UserStory> userStories;
	
	public Project(String type, String name) {
		projectType = type;
		projectName = name;
	}
	public void setType(String type) {
		projectType = type;
	}
	public void setName(String name) {
		projectName = name;
	}
	public void setDescription(String descr) {
		projectDescription = descr;
	}
	public String getType() {
		return projectType;
	}
	public String getName() {
		return projectName;
	}
	public String getDescription() {
		return projectDescription;
	}
	public String toString() {
		return("Project Information\n");
	}
}
