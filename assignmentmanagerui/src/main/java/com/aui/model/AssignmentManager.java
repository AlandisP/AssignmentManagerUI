package com.aui.model;

import java.util.ArrayList;
/**
 * this class is the main system that will handle our users and their data
 */
public class AssignmentManager {

    private static AssignmentManager instance;
    private UserList userList;
    private ArrayList<User> users;
    private User currentUser;
   /**
    * initializes the User List and make sure only one exists throughout the life of the program.  
    */
    public AssignmentManager() {
        userList = UserList.getInstance();
    }
    //this method makes sures only one instance of our manager exists.
    public static AssignmentManager getInstance() {
        if (instance == null) {
            instance = new AssignmentManager();
        }
        return instance;
     }

     public UserList getUserList() {
        return userList;
     }
     /**
      * uses a boolean to determine if the user can login or not. 
      * @param u the username inputted
      * @param pass the password inputted
      * @return returns true if the login is successful and sets the current user to the user that is logged in. false if credentials are incorrect
      */
     public boolean login(String u, String pass) {
        userList.getUsers();
        currentUser = userList.getUser(u); //Could possibly cause a bug, will test to see if it does.
        if(currentUser != null && pass.equals(currentUser.getPassword())) {
            return true;
        } else {
            currentUser = null;
            return false;
        }
     }
     /**
      * this method creates a new account for the User
      * @param u the inputted username
      * @param pass the password
      * @param pass2 the password(twice) we want to make sure that the user confirms the password twice as its a good security measure.
      * @return true if the account is created and sets the current user to the new account. False otherwise
      */
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
     //Getters and Setters for CurrentUser
     public void setCurrentUser(User u) {
        currentUser = u;
     }

     public User getCurrentUser() {
        return currentUser;
     }

     // this simply "logs out" the user by setting the current user to null and then saving the data
     public void logout(){
        currentUser = null;
        DataManager.saveUsers();
     }

}
