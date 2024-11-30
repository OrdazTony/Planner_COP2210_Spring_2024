
import java.util.Scanner;

public class Expenses {
    
    private static boolean checker = true;
    
        public static Double[] ExpInfo(double necTotal) {
            Scanner scnr = new Scanner(System.in);
            Double savings, paycheck, remainder, expenses, payPerCheck = 0.00;
            int choice = 0;
    
            System.out.println("What was your last paycheck? ");
            paycheck = scnr.nextDouble();
    
            while (checker == true) {
            System.out.println("The total you're spending on necessities this month is $" + necTotal +". What percentage of this would you like to cover with this paycheck?");
            System.out.println("1. 25%");
            System.out.println("2. 50%");
            System.out.println("3. 75%");
            choice = scnr.nextInt();

            if (choice == 1) {
                payPerCheck = necTotal * .25;
                checker = false;
            }
            else if (choice == 2) {
                payPerCheck = necTotal * .50;
                checker = false;
            }
            else if (choice == 3) {
                payPerCheck = necTotal * .75;
                checker = false;
            }
            else {
                System.out.println("Invalid option. Try again.");
            }

        }

        remainder = paycheck - payPerCheck;
        System.out.println("After allocating $" + payPerCheck + " to monthly expenses, you are left with $" + remainder + ".");
        System.out.println("How much of this would you like to put into savings?");
        savings = scnr.nextDouble();
        expenses = remainder - savings;

        System.out.println("That leaves you with $" + expenses + " for other expenses until your next paycheck.");
        
        Double[] fininfo = {paycheck, savings, expenses};
        return fininfo;

    }


}

