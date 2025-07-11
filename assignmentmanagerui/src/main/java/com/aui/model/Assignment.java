package com.aui.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment {

    private String name;    
    private String description;
    //Due date should be in MM/DD/YYYY Formatting
    private String dueDate;
    private boolean isCompleted;

    /**
     * Constructs the Assignment object initializing the name, description, and duedate of the assignment
     * completion status is always set to false initially.
     * @param name the name of the Assignment/task
     * @param description the assignments/tasks description
     * @param dueDate the duedate of the assignment.task
     */
    public Assignment(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        setDueDate(dueDate);
        this.isCompleted = false;
    }
    // Getters and Setters for the private variables
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    //Uses the Local Date object and SimpleDateFormate to set a valid date and make sure the user isn't allowed to input anything invalid
    public void setDueDate(String d) {
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
        ft.setLenient(false);

        try {
            Date inputDate = ft.parse(d);
            Date currentDate = new Date();

            //  Since im using the caldenar in my UI I no longer need this logic.
            // if (inputDate.after(currentDate)) {
            //     this.dueDate = d;
            // } else {
            //     this.dueDate = ft.format(currentDate);
            // }
            this.dueDate = d;

        } catch (Exception e) {
            // Invalid format or invalid date
            this.dueDate = ft.format(new Date()); 
        }
    }


    public void changeCompletion() {
        isCompleted = !isCompleted;
    }

    public void changeCompletion(boolean b) {
        isCompleted = b;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    //  Adds (Overdue) to an assignments date to show if its overdue. helps with the table view
    public String getDisplayDate() {
    if (isOverdue()) {
        return getDueDate() + " (Overdue)";
    }
    return getDueDate();
}
    /**
     * logic sees if an Assignment is Overdue
     * @return true if the assignment is overdue, false otherwise
     */
    public boolean isOverdue() {
        try {
            SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy"); 
            Date aDate = ft.parse(getDueDate());
            Date currentDate = new Date();
        
            return !getIsCompleted() && aDate.before(currentDate);
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    /**
     * returns the assignment details
     */
    public String toString() {
        return "Name: " + name + "\nDescription: " + description + "\nDue Date: " + dueDate + "\nCompleted: " + (isCompleted? "Yes" : "No");
    }
}
