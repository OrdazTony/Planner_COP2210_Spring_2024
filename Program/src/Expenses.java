
import java.util.Scanner;

public class Expenses {
    public Double[] ExpInfo() {
       Scanner scnr = new Scanner(System.in);
            Double ccp, loans, savings, rent, necTotal, paycheck, remainder, expenses;

            System.out.println("What are your credit card payments for the month? ");
            ccp = scnr.nextDouble();
            System.out.println("What are your loan payments for the month? ");
            loans = scnr.nextDouble();
            System.out.println("What is your rent payment for the month? ");
            rent = scnr.nextDouble();
            System.out.println("What was your last paycheck? ");
            paycheck = scnr.nextDouble();


            necTotal = ccp + loans + rent;
            remainder = paycheck - necTotal;

            System.out.println("The total you're spending on necessities this month is $" + necTotal +". This leaves you with $" + remainder + ".");
            System.out.println("How much would you like to put in savings?");

            savings = scnr.nextDouble();
            expenses = remainder - savings;

            System.out.println("That leaves you with $" + expenses + " for other expenses throughout the month.");
            
            Double[] fininfo = {paycheck, ccp, loans, rent, savings, expenses};
            return fininfo;

    }


    }

