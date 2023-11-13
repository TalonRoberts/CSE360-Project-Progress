package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserStoryWriter {

    public static void writeUserStoriesToFile(String filePath, ArrayList<UserStory> stories) {
        BufferedWriter bw = null; // Declare outside the try block for access in the finally block
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (UserStory story : stories) {
                // Format the UserStory data as a line in the text file
                String line = story.getProjectName() + "," + story.getProjDesc() + "," 
                + story.getStoryName() + "," + story.getStory() + "," + story.getWeight() +
                 "," + story.getUserRole() + "," + story.getProjLang() + "," + story.getDomain();
                  
                bw.write(line);
                bw.newLine(); // Add a new line for the next user story
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing BufferedWriter: " + e.getMessage());
            }
        }
    }
}
