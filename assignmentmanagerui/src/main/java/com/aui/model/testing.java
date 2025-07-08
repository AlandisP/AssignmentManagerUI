package com.aui.model;
public class testing {

    public static void main(String[] args) {

        AssignmentManager manager = AssignmentManager.getInstance();

    //     Scanner scan = new Scanner(System.in);
    //     System.out.println("Welcome to the Assignment Manager created by Alandis Patterson!");
    //     boolean running = true;
    //     while (running) { 
    //         displayOptions();
    //         int input = scan.nextInt();
    //         scan.nextLine();
    //         switch(input){
    //             case 1: 
    //                 System.out.println("Enter the name of the assignment: ");
    //                 String name = scan.nextLine();
    //                 System.out.println("Enter the description of the assignment: ");
    //                 String description = scan.nextLine();
    //                 System.out.println("Enter the due date of the assignment(Must be in MM/DD/YYYY Format)): ");
    //                 String date = scan.nextLine();
    //                 Assignment a = new Assignment(name, description, date);
    //                 manager.addAssignment(a);
    //                 //DataManager.saveAssignments();
    //                 break;
    //             case 2:
    //                 System.out.println("Enter the name of the assignment that you'd like to delete");
    //                 String nameOfAssignment = scan.nextLine();
    //                 while(!manager.findAssignment(nameOfAssignment)) {
    //                     System.out.println("Invalid Assignment, please enter another one. Type \" STOP \" to quit");
    //                     nameOfAssignment = scan.nextLine();
    //                     if(nameOfAssignment.equalsIgnoreCase("STOP")) {
    //                         break;
    //                     }
    //                 }
    //                 manager.deleteAssignment(nameOfAssignment);
    //                 //DataManager.saveAssignments();
    //                 break;
    //             case 3:
    //                 System.out.println("Press 1 to edit an assignment name\nPress 2 to edit an assignment due date\nPress 3 to edit assignment description\nPress 4 to change Assignment completion status\nPress 0 to stop");
    //                 int choice = scan.nextInt();
    //                 while(choice != 0) {
    //                     switch(choice) {
    //                         case 1:
    //                             System.out.println("Enter the assignment's name. Type \"STOP\" to exit");
    //                             String n = scan.nextLine();
    //                             while(!manager.findAssignment(n)) {
    //                                 if(n.equalsIgnoreCase("STOP")) {
    //                                     break;
    //                                 }
    //                                 System.out.println("Invald name, please enter a valid name: ");
    //                                 n = scan.nextLine();
    //                             }
    //                             System.out.println("Enter the new name of the Assignment: ");
    //                             String nn = scan.nextLine();
    //                             manager.editAssignmentName(n, nn); 
    //                             //DataManager.saveAssignments();
    //                             break;
    //                         case 2:
    //                             System.out.println("Enter the assignment's name. Type \"STOP\" to exit");
    //                             String name3 = scan.nextLine();
    //                             while(!manager.findAssignment(name3)) {
    //                                 if(name3.equalsIgnoreCase("STOP")) {
    //                                     break;
    //                                 }
    //                                 System.out.println("Invald name, please enter a valid name");
    //                                 name3 = scan.nextLine();
    //                             }
    //                             System.out.println("Enter the new due date(MM/DD/YYYY Format)");
    //                             String date2 = scan.nextLine();
    //                             manager.editAssignmentDate(name3, date2);
    //                             //DataManager.saveAssignments();
    //                             break;
    //                         case 3:
    //                             System.out.println("Enter the assignment's name. Type \"STOP\" to exit");
    //                             String name4 = scan.nextLine();
    //                             while(!manager.findAssignment(name4)) {
    //                                 if(name4.equalsIgnoreCase("STOP")) {
    //                                     break;
    //                                 }
    //                                 System.out.println("Invald name, please enter a valid name");
    //                                 name4 = scan.nextLine();
    //                             }
    //                             System.out.println("Enter the new description");
    //                             String d = scan.nextLine();
    //                             manager.editAssignmentDate(name4, d);
    //                             //DataManager.saveAssignments();
    //                             break;
    //                         case 4:
    //                             System.out.println("Enter the assignment's name. Type \"STOP\" to exit");
    //                             String name5 = scan.nextLine();
    //                             while(!manager.findAssignment(name5)) {
    //                                 if(name5.equalsIgnoreCase("STOP")) {
    //                                     break;
    //                                 }
    //                                 System.out.println("Invald name, please enter a valid name");
    //                                 name5 = scan.nextLine();
    //                             }
    //                             manager.changeAssignmentCompletion(name5);
    //                             //DataManager.saveAssignments();
    //                             break;
    //                         case 0:
    //                             break;
    //                     }
    //                 }
    //                 break;
    //             case 4:
    //                 System.out.println(manager.printAssignmentList());
    //                 break;
    //             case 0:
    //                 running = false;
    //                 //DataManager.saveAssignments();
    //                 System.out.println("Bye!");
    //                 System.exit(0);
    //         }
    //     }
    }


    private static void displayOptions() {
        System.out.println("Press 1 to Add an Assignment\nPress 2 to Delete an Assignment\nPress 3 to edit an assignment\nPress 4 to view the assignment list\nPress 0 to quit");
    }
    
}
