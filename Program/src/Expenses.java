import java.util.Scanner;
// This class was developed by John and edited by Anthony and John, updated using github.
public class Expenses {

    public static Double[] ExpInfo2(double necTotal) {
        Scanner scnr = new Scanner(System.in);
        double savings = 0, paycheck = 0, paycheckFinal = 0;
        Boolean isRunning = true;

        while (isRunning) {
            System.out.println("--------------");
            System.out.println("What was your last paycheck? ");
            paycheck = scnr.nextDouble();
            paycheckFinal = paycheck;
            if (necTotal == 0 && paycheck > necTotal) {
                System.out.println("--------------");
                System.out.println("You already paid your monthly necessities. How much of your paycheck would you like to put into savings?");
                savings = scnr.nextDouble();
                paycheck = paycheck - savings;
                System.out.println("--------------");
                System.out.printf("That leaves you with $%.2f until your next paycheck.%n", paycheck);
                break;
            } else if (necTotal > 0 && paycheck >= necTotal) {
                paycheck = paycheck - necTotal;
                System.out.println("--------------");
                System.out.printf("You still have to pay $%.2f for this month's necessities. That leaves you with $%.2f.%n", necTotal, paycheck);
                System.out.println("How much of this would you like to put into savings?");
                savings = scnr.nextDouble();
                paycheck = paycheck - savings;
                System.out.println("--------------");
                System.out.printf("That leaves you with $%.2f until your next paycheck.%n", paycheck);
                necTotal = 0;
                break;
            } else {
                System.out.println("--------------");
                System.out.println("You either entered an invalid number, or your input was lower than the amount you still have to pay for necessities. Please try again.");
            }
        }

        return new Double[] {paycheckFinal, savings, paycheck, necTotal};

    }

    public static Double[] ExpInfo(double necTotal) {
        Scanner scnr = new Scanner(System.in);
        double savings, paycheck = 0.00, remainder, expenses, payPerCheck = 0.00, remAfterNec;
        int choice;
        boolean whilePos = true;

        // Get paycheck amount
        while (whilePos) {
            System.out.println("--------------");
            System.out.println("What was your last paycheck? ");
            paycheck = scnr.nextDouble();
            if (paycheck < necTotal * 0.25) {
                System.out.println("--------------");
                System.out.println("Your paycheck is lower than 25% of your monthly necessities. Please try again.");
            } else {
                break;
            }
        }
        
        // Choose percentage to allocate to necessities
        boolean isValid = false;
        while (!isValid) {
            System.out.println("--------------");
            System.out.printf("The total you're spending on necessities this month is $%.2f. What percentage of this would you like to cover with this paycheck?%n", necTotal);
            System.out.println("---------");
            if (paycheck >= necTotal * .25) {
                System.out.println("1. 25%");
            }
            if (paycheck >= necTotal * .50) {
                System.out.println("2. 50%");
            }
            if (paycheck >= necTotal * .75) {
                System.out.println("3. 75%");
            }
            if (paycheck >= necTotal){
                System.out.println("4. 100%");
            }
            System.out.println("---------");
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
                System.out.println("--------------");
                System.out.println("Invalid option. Try again.");
            }
        }

        // Calculate remainder
        remainder = paycheck - payPerCheck;
        remAfterNec = necTotal - payPerCheck;
        System.out.println("--------------");
        System.out.printf("After allocating $%.2f to monthly expenses, you are left with $%.2f.%n", payPerCheck, remainder);

        // Allocate savings
        while(true) {
            System.out.println("--------------");
            System.out.println("How much of this would you like to put into savings?");
            savings = scnr.nextDouble();
            if(savings < 0){
                System.out.println("--------------");
                System.out.println("Error: Invalid savings amount");
            }else if (savings > remainder){
                System.out.println("--------------");
                System.out.println("Error: Invalid savings amount");
            }else {break;}
        }

        // Calculate other expenses
        expenses = remainder - savings;
        System.out.println("--------------");
        System.out.printf("That leaves you with $%.2f for other expenses until your next paycheck.%n", expenses);

        // Return financial information
        return new Double[]{paycheck, savings, expenses, remAfterNec};
    }

}
