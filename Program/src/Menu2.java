import java.util.Scanner;

public class Menu {

    private boolean isRunning;

    public Menu() {
        isRunning = true;
    }

    public void displayMenu() {
        Scanner scnr = new Scanner(System.in);

        while (isRunning) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create New User");
            System.out.println("2. Quit Program");
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
                Expenses.ExpInfo(necTotal);
                

            } else if (choice == 2) {
                quitProgram();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void quitProgram() {
        System.out.println("Quitting program. Goodbye!");
        isRunning = false;
    }
}
