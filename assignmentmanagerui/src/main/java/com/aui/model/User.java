package com.aui.model;
import java.util.ArrayList;
/**
 * this is the User class
 * it has the needed details for the user and other things to help the program function.
 */
public class User {

    private String username;
    private String password;
    private ArrayList<Assignment> assignments;
    private Assignment currentAssignment; //this here is used as a selector. If theres something in the list then it would be the first element
                                            //if nothing its null. This just used for selecting assignments to edit.

    /**
     * constructs the user object
     * @param uN the username
     * @param pW the password
     * @param a the arraylist of assignments
     */
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
    //Getters and Setters
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
    /**
     * this gets the progress percentage based on if something is completed or not
     * @return returns a double of the progress percentage. Had to cast due to issues with int and double operations
     */
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
    /**
     * adds a assignment to the list
     * @param a the Assignment object 
     */
    public void addAssignment(Assignment a) {
        this.assignments.add(a);
    }
    /**
     * this finds an assignment by name
     * @param name the given name
     * @return return the assignment with that selected name or null if it isn't found
     */
    public  Assignment findAssignmentByName(String name) {
        for(int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getName().equalsIgnoreCase(name)) {
                return assignments.get(i);
            }
        }        return null;
    }
    //deletes the assignment from the list(object)
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
