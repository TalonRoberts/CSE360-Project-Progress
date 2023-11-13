package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import application.Employee;

public class UserStoryReader {

	public static ArrayList<UserStory> readUserStoriesFromFile(String filePath) {
	    ArrayList<UserStory> stories = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            // Split the line into components (assuming they are separated by a delimiter like comma)
	            String[] parts = line.split(",");

	            // Check if the array has enough elements
	            if (parts.length >= 8) {
	                // Parse the components and create an Employee object
	                //int projName = Integer.parseInt(parts[0]);
                    String projName = parts[0];
                    String projDesc = parts[1];
                    String storyName = parts[2];
	                String userStory = parts[3];
	                int weight = Integer.parseInt(parts[4]);
                    String role = parts[5];
	                String lang = parts[6];
                    String domain = parts[7];

	                UserStory story = new UserStory(projName,projDesc,storyName, userStory, weight, role, lang, domain);
	                stories.add(story);
	            } else {
	                System.out.println("Skipping line: " + line);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace(); // Handle the exception according to your needs
	    }

	    return stories;
	}
}