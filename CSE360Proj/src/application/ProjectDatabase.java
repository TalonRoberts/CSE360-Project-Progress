package application;

import java.util.ArrayList;

public class ProjectDatabase {
	private static ProjectDatabase instance;
	private ArrayList<Project> projectList;
	
	private ProjectDatabase() {
		projectList = new ArrayList<>();
	}
	
	public static ProjectDatabase getInstance() {
		if (instance == null) {
			instance = new ProjectDatabase();
		}
		return instance;
	}
	
	public void addProject(Project project) {
		projectList.add(project);
	}
	
	public void removeProject(Project project) {
		projectList.remove(project);
	}
	
	public Project getProject(ArrayList<Project> list, String name) {
		for (Project project: list) {
			if (project.getName().equals(name)) {
				return project;
			}
		}
		return null;
	}
	public ArrayList<Project> getProjectList(){
		return projectList;
	}
	
}
