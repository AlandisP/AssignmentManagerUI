package com.aui.model;

import java.util.ArrayList;
public class AssignmentManager {

    private static AssignmentManager instance;
    private ArrayList<Assignment> assignments;
    private Assignment currentAssignment;

    public AssignmentManager() {
        this.assignments = DataManager.loadAssignments();
        if(assignments.size() > 0) {
            currentAssignment = assignments.get(0);
        } else {
            currentAssignment = null;
        }
    }

    public static AssignmentManager getInstance() {
        if (instance == null) {
            instance = new AssignmentManager();
        }
        return instance;
     }

     public ArrayList<Assignment> getAssignments() {
        return assignments;
     }


    public void addAssignment(Assignment a) {
        this.assignments.add(a);
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

    public boolean editAssignmentName(String assignmentName, String name) {
        Assignment target = findAssignmentByName(assignmentName);
        if (target != null) {
            target.setName(name);
            return true;
        }
        return false;
    }

    public boolean editAssignmentDate(String assignmentName, String date) {
        Assignment target = findAssignmentByName(assignmentName);
        if (target != null) {
            target.setDueDate(date);
            return true;
        }
        return false;
    }

    public boolean editAssignmentDescription(String assignmentName, String description) {
        Assignment target = findAssignmentByName(assignmentName);
        if (target != null) {
            target.setDescription(description);
            return true;
        }
        return false;
    }

    public boolean changeAssignmentCompletion(String assignmentName) {
        Assignment target = findAssignmentByName(assignmentName);
        if (target != null) {
            target.changeCompletion();
        }
        return false;
    }

    public  Assignment findAssignmentByName(String name) {
        for(int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getName().equalsIgnoreCase(name)) {
                return assignments.get(i);
            }
        }
        return null;
    }

    public boolean findAssignment(String name) {
        for(int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }


    public String printAssignmentList() {
        String str = "----------------------------------------------------------------\n";
        for(int i = 0; i < assignments.size(); i++) {
            str+= assignments.get(i).toString() + "\n----------------------------------------------------------------\n";
        }
        return str;
    }

    public void changeCurrentAssignment(Assignment cA) {
        currentAssignment = cA;
    }

    public Assignment getCurrentAssignment() {
        return currentAssignment;
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
    
}
