package com.aui.model;
import java.util.*;

public class UserList {
    private static UserList userList = null;
    private static ArrayList<User> users = new ArrayList<User>();


    public UserList() {
        users = DataManager.loadUsers();
    }

    public static UserList getInstance() {
        if(userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(String uN, String pW, ArrayList<Assignment> a) {
        users.add(new User(uN, pW, a));
    }

    public void addUser(User u) {
        users.add(u);
    }

    public User getUser(String name) {
        for(User u: users) {
            if(u.getUsername().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }

    public boolean findUserByName(String name) {
        for(User u: users) {
            if(u.getUsername().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void logout() {
        DataManager.saveUsers();
    }


    
}
