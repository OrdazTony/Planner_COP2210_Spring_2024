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
                System.out.println("Please enter your name: ");
                String name = scnr.nextLine();
                System.out.println("Please enter your age: ");
                int age = scnr.nextInt();
                scnr.nextLine();
                User user = new User(name, age);
                user.calculateExpenses();

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
