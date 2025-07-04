package com.aui.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment {

    private String name;
    private String description;
    //Due date should be in MM/DD/YYYY Formatting
    private String dueDate;
    private boolean isCompleted;

    public Assignment(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        setDueDate(dueDate);
        this.isCompleted = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String d) {
        this.description = d;
    }


    public void setDueDate(String d) {
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
        ft.setLenient(false);

        try {
            Date inputDate = ft.parse(d);
            Date currentDate = new Date();

            if (inputDate.after(currentDate)) {
                this.dueDate = d;
            } else {
                this.dueDate = ft.format(currentDate);
            }
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
    
    @Override
    public String toString() {
        return "Name: " + name + "\nDescription: " + description + "\nDue Date: " + dueDate + "\nCompleted: " + (isCompleted? "Yes" : "No");
    }
}
