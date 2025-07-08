package com.aui.model;
import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private ArrayList<Assignment> assignments;
    private Assignment currentAssignment;

    public User(String uN, String pW, ArrayList<Assignment> a) {
        this.username = uN;
        this.password = pW;
        this.assignments = a;
        if(assignments.size() > 0) {
            currentAssignment = assignments.get(0);
        } else {
            currentAssignment = null;
        }
    }

    public void setUsername(String uN) {
        this.username = uN;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public void setAssignments(ArrayList<Assignment> a) {
        this.assignments = a;
    }

    public void setCurrentAssignment(Assignment a) {
        this.currentAssignment = a;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public double getProgressPercentage() {
        if (assignments.isEmpty()) {
            return 0.0; 
        }
        double isCompleted = 0.0;
        for(int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getIsCompleted()) {
                isCompleted++;
            }
        }
        return ((double)(isCompleted/assignments.size()));
    }

    public Assignment getCurrentAssignment() {
        return currentAssignment;
    }

    public String toString() {

        String assignmentStrings = "";
        for(Assignment a: assignments) {
            assignmentStrings = assignmentStrings + a.toString() + " ";
        }
        return username + "\n" + assignmentStrings;
    }

    public String printAssignmentList() {
        String str = "----------------------------------------------------------------\n";
        for(int i = 0; i < assignments.size(); i++) {
            str+= assignments.get(i).toString() + "\n----------------------------------------------------------------\n";
        }
        return str;
    }

    public void addAssignment(Assignment a) {
        this.assignments.add(a);
    }

    public  Assignment findAssignmentByName(String name) {
        for(int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getName().equalsIgnoreCase(name)) {
                return assignments.get(i);
            }
        }        return null;
    }

    public void deleteAssignment(Assignment a) {
        assignments.remove(a);
    }

    public boolean deleteAssignment(String name) {
        Assignment target = findAssignmentByName(name);
        if(target != null) {
            assignments.remove(target);
            return true;
        }
        return false;   
    }
    
    public void changeCurrentAssignment(Assignment cA) {
        currentAssignment = cA;
    }



    
}
