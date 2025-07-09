package com.aui.model;
import java.util.*;
/**
 * this is the UserList class that holds the users
 */
public class UserList {
    private static UserList userList = null;
    private static ArrayList<User> users = new ArrayList<User>();

    /*
     * the object is initialized and the users are loaded.
     */
    public UserList() {
        users = DataManager.loadUsers();
    }
    /**
     * we only want one instance of this object to exist
     * @return the instance of the class
     */
    public static UserList getInstance() {
        if(userList == null) {
            userList = new UserList();
        }
        return userList;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    //adds a new user to the list
    public void addUser(String uN, String pW, ArrayList<Assignment> a) {
        users.add(new User(uN, pW, a));
    }

    public void addUser(User u) {
        users.add(u);
    }
    //gets the user by the name
    public User getUser(String name) {
        for(User u: users) {
            if(u.getUsername().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }
    //finds a user by the name(returns true if its found)
    public boolean findUserByName(String name) {
        for(User u: users) {
            if(u.getUsername().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    //saves the users 
    public void logout() {
        DataManager.saveUsers();
    }


    
}
