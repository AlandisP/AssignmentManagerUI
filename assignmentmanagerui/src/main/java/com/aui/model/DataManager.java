package com.aui.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class DataManager {

    private static final String DATA_DIR = System.getProperty("user.home"); //just used this in case I wanted to make it an official application
    private static final String JSON_FILE_PATH = "assignmentmanagerui/src/main/java/com/aui/data/Users.json"; //file path

    //This method uses JSON parsing the put users in a JSON with all of there information. (Name. Password, Tasks)
    public static void saveUsers() {
        UserList uL = UserList.getInstance();
        ArrayList<User> users = uL.getUsers();
        JSONArray list = new JSONArray();
        for(int i = 0; i < users.size(); i++) {
            JSONObject currUser = new JSONObject();
            currUser.put("username:", users.get(i).getUsername());
            currUser.put("password:", users.get(i).getPassword());
            JSONArray userAssignmentsJSON = new JSONArray();
            ArrayList<Assignment> userAssignments = users.get(i).getAssignments();
            for(int j = 0; j < userAssignments.size(); j++) {
                JSONObject a = new JSONObject();
                a.put("name:", userAssignments.get(j).getName());
                a.put("description:", userAssignments.get(j).getDescription());
                a.put("duedate:", userAssignments.get(j).getDueDate());
                a.put("completion:", userAssignments.get(j).getIsCompleted());
                userAssignmentsJSON.add(a);
            }
            currUser.put("tasks:", userAssignmentsJSON);
            list.add(currUser);
        }

        try(FileWriter file  = new FileWriter(JSON_FILE_PATH)) {
            file.write(list.toJSONString());
            file.flush();

        } catch(Exception e) {
            System.out.println("Error creating file " + e.getMessage());
            e.printStackTrace();
        }
    }

    //This returns information read from a JSON to an ArrayList so we can have all the User Data in a list
    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(JSON_FILE_PATH);
            JSONParser parser = new JSONParser();
            JSONArray aJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < aJSON.size(); i++) {
                JSONObject userInfoJSON = (JSONObject)aJSON.get(i);
                String username = (String)userInfoJSON.get("username:");
                String password = (String)userInfoJSON.get("password:");

                JSONArray userTasks = (JSONArray)userInfoJSON.get("tasks:");
                ArrayList<Assignment> aS = new ArrayList<>();
                for(int j = 0; j < userTasks.size(); j++) {//Nested for loops to access the array of assignments
                    JSONObject taskInfo = (JSONObject)userTasks.get(j);
                    String name = (String)taskInfo.get("name:");
                    String description = (String)taskInfo.get("description:");
                    String dueDate = (String)taskInfo.get("duedate:");
                    boolean isCompleted = (boolean)taskInfo.get("completion:");
                    Assignment a = new Assignment(name, description, dueDate);
                    if(isCompleted) {
                        a.changeCompletion();
                    }
                    aS.add(a);
                }
                User u = new User(username, password, aS);
                users.add(u);
            }
            return users;
            
        } catch (Exception e) {
            System.out.println("Couldnt find file or file is empty. " + e.getMessage());
            return new ArrayList<User>();// returns an empty list if there aren't any users.
        }
        


    }
    
    
}
