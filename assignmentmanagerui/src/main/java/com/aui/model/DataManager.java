package com.aui.model;

import java.util.*;
import org.json.simple.parser.*;
import org.json.simple.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.io.*;
public class DataManager {

    private static final String DATA_DIR = System.getProperty("user.home");
    private static final String JSON_FILE_PATH = "assignmentmanagerui/src/main/java/com/aui/data/UserAssignments.json";

    public static void saveAssignments() {
        AssignmentManager aM = AssignmentManager.getInstance();
        ArrayList<Assignment> assignments = aM.getAssignments();
        JSONArray list = new JSONArray();
        for(int i = 0; i < assignments.size(); i++) {
            JSONObject a = new JSONObject();
            a.put("name:", assignments.get(i).getName());
            a.put("description:", assignments.get(i).getDescription());
            a.put("duedate:", assignments.get(i).getDueDate());
            a.put("completion:", assignments.get(i).getIsCompleted());
            list.add(a);
        }

        try(FileWriter file  = new FileWriter(JSON_FILE_PATH)) {
            file.write(list.toJSONString());
            file.flush();

        } catch(Exception e) {
            System.out.println("Error creating file " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Assignment> loadAssignments() {
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();

        try {
            FileReader reader = new FileReader(JSON_FILE_PATH);
            JSONParser parser = new JSONParser();
            JSONArray aJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < aJSON.size(); i++) {
                JSONObject assignmentJSON = (JSONObject)aJSON.get(i);
                String name = (String)assignmentJSON.get("name:");
                String description = (String)assignmentJSON.get("description:");
                String dueDate = (String)assignmentJSON.get("duedate:");
                boolean isCompleted = (boolean)assignmentJSON.get("completion:");
                Assignment a = new Assignment(name, description, dueDate);
                if(isCompleted) {
                    a.changeCompletion();
                }
                assignments.add(a);
            }
            return assignments;
            
        } catch (Exception e) {
            System.out.println("Couldnt find File. " + e.getMessage());
            e.printStackTrace();
        }
        return null;


    }
    
    
}
