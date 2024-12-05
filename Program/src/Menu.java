import java.util.ArrayList;
import java.util.Scanner;
//Menu was implemented by Anthony and John
//Idea and look of the interface was developed by everyone

public class Menu {

    private boolean isRunning, while1, while2;

    public Menu() {
        isRunning = true;
        while1 = true;
        while2 = true;
    }

    public void displayMenu() {
        Scanner scnr = new Scanner(System.in);
        UserList userList = new UserList();

        while (isRunning) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create New User");
            System.out.println("2. Add New Paycheck");
            System.out.println("3. Show Users");
            System.out.println("4. Print financial history: ");
            System.out.println("5. Quit Program");
            System.out.print("Choose an option: ");

            int choice = scnr.nextInt();
            scnr.nextLine();

            if (choice == 1) {
                //basic user info
                System.out.println("--------------");
                System.out.println("Please enter your name: ");
                String name = scnr.nextLine();
                System.out.println("--------------");
                System.out.println("Please enter your age: ");
                int age = scnr.nextInt();
                User user = new User(name, age);

                //monthly expenses
                while (while1) {
                    System.out.println("--------------");
                    System.out.println("What are your credit card payments for the month? ");
                    double ccp = scnr.nextDouble();
                    if (ccp < 0) {         //error checking for negatives
                        System.out.println("--------------");
                        System.out.println("Invalid input, please try again.");
                        continue;
                    }
                    System.out.println("--------------");
                    System.out.println("What are your loan payments for the month? ");
                    double loans = scnr.nextDouble();
                    if (loans < 0) {       //error checking for negatives
                        System.out.println("--------------");
                        System.out.println("Invalid input, please try again.");
                        continue;
                    }
                    System.out.println("--------------");
                    System.out.println("What is your rent payment for the month? ");
                    double rent = scnr.nextDouble();
                    if (rent < 0) {        //error checking for negatives
                        System.out.println("--------------");
                        System.out.println("Invalid input, please try again.");
                        continue;
                    }
                    double necTotal = ccp+loans+rent;
                    System.out.println("--------------");
                    System.out.printf("Your monthly necessities cost is $%.2f.%n", necTotal);
                    scnr.nextLine();
                    Double[] info = Expenses.ExpInfo(necTotal);
                    user.setFinHistory(info);
                    userList.addUser(user);
                    break;
                }

            } else if (choice == 2) {
                while2 = true;
                while (while2) {
                    System.out.println("--------------");
                    System.out.println("Please enter your name: ");
                    String name = scnr.next();
                    for (int i = 0; i < userList.size(); i++) {
                        User user = userList.users.get(i);
                        if (name == null ? user.getName() == null : name.equals(user.getName())) {
                            System.out.println("--------------");
                            System.out.println("Is it a new month? Type 'Yes' or 'No'.");
                            String newMonth = scnr.next();
                        
                            if ("No".equals(newMonth)) {
                                ArrayList<Double> history = user.getFinHistory();
                                double remAfterNec = history.get(3);
                                user.editFinHistory(Expenses.ExpInfo2(remAfterNec));
                                while2 = false;
                                break;
                            } else if ("Yes".equals(newMonth)) {
                                System.out.println("--------------");
                                System.out.println("What are your credit card payments for the month? ");
                                double ccp = scnr.nextDouble();
                                System.out.println("--------------");
                                System.out.println("What are your loan payments for the month? ");
                                double loans = scnr.nextDouble();
                                System.out.println("--------------");
                                System.out.println("What is your rent payment for the month? ");
                                double rent = scnr.nextDouble();
                                double necTotal = ccp+loans+rent;
                                System.out.println("--------------");
                                System.out.printf("Your monthly necessities cost is $%.2f.%n", necTotal);
                                scnr.nextLine();
                                Double[] info = Expenses.ExpInfo(necTotal);
                                user.editFinHistory(info);
                                while2 = false;
                                break;
                            } else {
                                System.out.println("--------------");
                                System.out.println("Invalid input. Please try again.");
                                break;
                            }
                        
                        }
                    }
                    if (while2 == true) {
                        System.out.println("--------------");
                        System.out.println("There is no user under that name, please try again.");
                    }
                }

            } else if (choice == 3) {
                System.out.println("List of users:");
                for (int i = 0; i < userList.size(); i++) {
                    System.out.println(userList.users.get(i)); // Print each user
                }
            } else if (choice == 4) {
                System.out.println("Financial histories of users:");
                System.out.println("--------------");
                for (int i = 0; i < userList.size(); i++) {
                    User user = userList.users.get(i);
                    System.out.println("Financial History for " + user.getName() + ":");
                    ArrayList<Double> hist = user.getFinHistory();
                    System.out.printf("Last paycheck: $%.2f%n", hist.get(0));
                    System.out.printf("Savings: $%.2f%n", hist.get(1));
                    System.out.printf("Remainder until next paycheck: $%.2f%n", hist.get(2));
                    System.out.println("--------------");
                        
                }
            }
            else if (choice == 5) {
                quitProgram();
            }
            else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void quitProgram() {
        System.out.println("Quitting program. Goodbye!");
        isRunning = false;
    }
}
