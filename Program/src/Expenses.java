import java.util.Scanner;
// This class was developed by John and edited by Anthony and John, updated using github.
public class Expenses {

    public static Double[] ExpInfo(double necTotal) {
        Scanner scnr = new Scanner(System.in);
        double savings, paycheck, remainder, expenses, payPerCheck = 0.00;
        int choice;

        // Get paycheck amount
        System.out.println("What was your last paycheck? ");
        paycheck = scnr.nextDouble();


        // Choose percentage to allocate to necessities
        boolean isValid = false;
        while (!isValid) {


            System.out.println("The total you're spending on necessities this month is $" + necTotal + ". What percentage of this would you like to cover with this paycheck?");
            System.out.println("1. 25%");
            System.out.println("2. 50%");
            System.out.println("3. 75%");
            System.out.println("4. 100%");
            choice = scnr.nextInt();

            if (choice == 1) {
                payPerCheck = necTotal * 0.25;
                isValid = true;
            } else if (choice == 2) {
                payPerCheck = necTotal * 0.50;
                isValid = true;
            } else if (choice == 3) {
                payPerCheck = necTotal * 0.75;
                isValid = true;
            } else if (choice == 4) {
                payPerCheck = necTotal;
                isValid = true;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        // Calculate remainder
        remainder = paycheck - payPerCheck;
        System.out.printf("After allocating $%.2f to monthly expenses, you are left with $%.2f.%n", payPerCheck, remainder);

        // Allocate savings
        while(true) {
            System.out.println("How much of this would you like to put into savings?");
            savings = scnr.nextDouble();
            if(savings < 0){
                System.out.println("Error: Invalid savings amount");
            }else if (savings > remainder){
                System.out.println("Error: Invalid savings amount");
            }else {break;}
        }

        // Calculate other expenses
        expenses = remainder - savings;
        System.out.printf("That leaves you with $%.2f for other expenses until your next paycheck.%n", expenses);
        // Error checking
        if (paycheck < necTotal) {
            System.out.println("Error: Insufficient income for expenses. Your paycheck must be greater than your total expenses.");
        }

        // Return financial information
        return new Double[]{paycheck, savings, expenses};
    }
}
