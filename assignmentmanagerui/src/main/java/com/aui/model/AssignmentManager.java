package com.aui.model;

import java.util.ArrayList;
public class AssignmentManager {

    private static AssignmentManager instance;
    private UserList userList;
    private ArrayList<User> users;
    private User currentUser;

    public AssignmentManager() {
        userList = UserList.getInstance();
    }

    public static AssignmentManager getInstance() {
        if (instance == null) {
            instance = new AssignmentManager();
        }
        return instance;
     }

     public UserList getUserList() {
        return userList;
     }

     public boolean login(String u, String pass) {
        userList.getUsers();
        currentUser = userList.getUser(u);
        if(currentUser != null && pass.equals(currentUser.getPassword())) {
            return true;
        } else {
            currentUser = null;
            return false;
        }
     }

     public boolean createAccount(String u, String pass, String pass2) {
        userList.getUsers();
        if(userList.findUserByName(u) == false && pass.equals(pass2)) {
            ArrayList<Assignment> arr = new ArrayList<>();
            User newUser = new User(u, pass, arr);
            userList.addUser(newUser);
            DataManager.saveUsers();
            currentUser = newUser;
            return true;
            
        }
        return false;
     }

     public void setCurrentUser(User u) {
        currentUser = u;
     }

     public User getCurrentUser() {
        return currentUser;
     }

     public void logout(){
        currentUser = null;
        DataManager.saveUsers();
     }

}
