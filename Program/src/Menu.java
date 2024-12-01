import java.util.Scanner;
//Menu was implemented by Anthony and John
//Idea and look of the interface was developed by everyone

public class Menu {

    private boolean isRunning;

    public Menu() {
        isRunning = true;
    }

    public void displayMenu() {
        Scanner scnr = new Scanner(System.in);
        UserList userList = new UserList();

        while (isRunning) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create New User");
            System.out.println("2. Show Users");
            System.out.println("3. print financial history: ");
            System.out.println("4. Quit Program");
            System.out.print("Choose an option: ");

            int choice = scnr.nextInt();
            scnr.nextLine();

            if (choice == 1) {
                //basic user info
                System.out.println("Please enter your name: ");
                String name = scnr.nextLine();
                System.out.println("Please enter your age: ");
                int age = scnr.nextInt();
                User user = new User(name, age);

                //monthly expenses
                System.out.println("What are your credit card payments for the month? ");
                double ccp = scnr.nextDouble();
                System.out.println("What are your loan payments for the month? ");
                double loans = scnr.nextDouble();
                System.out.println("What is your rent payment for the month? ");
                double rent = scnr.nextDouble();
                double necTotal = ccp+loans+rent;
                System.out.println("Your monthly necessities cost is $" + necTotal + ".");
                scnr.nextLine();
                user.setFinHistory(Expenses.ExpInfo(necTotal));
                userList.addUser(user);

            } else if (choice == 2) {
                System.out.println("List of users:");
                for (int i = 0; i < userList.size(); i++) {
                    System.out.println(userList.users.get(i)); // Print each user
                }
            } else if (choice == 3) {
                System.out.println("Financial histories of users:");
                for (int i = 0; i < userList.size(); i++) {
                    User user = userList.users.get(i);
                    System.out.println("Financial History for " + user.getName() + ":");
                    for (Double[] history : user.getFinHistory()) {
                        System.out.println("Paycheck: " + history[0] + ", Savings: " + history[1] + ", Other Expenses: " + history[2]);
                    }
                }
            }
            else if (choice == 4) {
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
