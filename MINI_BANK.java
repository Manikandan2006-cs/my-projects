package my_learnings;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MINI_BANK
{
    static Scanner scan = new Scanner(System.in);
    static boolean isTrue = true;
    public static void main(String[]args) {
        byte try_count = 0;
        int account_pin = 131149;
        int pin =0;
        double account_balance = 1000;
        pin_verify(try_count,account_pin,pin,account_balance);
    }
    private static void pin_verify(byte try_count,int account_pin ,int pin,double account_balance) {
        while (isTrue && try_count < 3) {
            try {
                System.out.print("\nenter your 6 digit pin : ");
                pin = scan.nextInt();

                if (pin != account_pin  ) {
                    if (Integer.toString(account_pin).length() != (Integer.toString(pin).length())) {
                        System.out.println("THE PIN SHOULD CONTAINS 6 DIGITS");
                    } else {
                        System.out.println("INVALID PIN");
                    }
                    try_count += 1;
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                try_count += 1;
                scan.next();
            }
            if (pin == account_pin) {

                try_count = 0;

                System.out.println();
                System.out.println("1.view balance");
                System.out.println("2.withdraw amount");
                System.out.println("3.deposit amount");
                System.out.println("4.exit");

               try {
                    System.out.print("\nenter your option:");
                    byte option = scan.nextByte();


                switch (option) {
                    case 1 -> balance(account_balance);
                    case 2 -> account_balance = withdraw(account_balance);
                    case 3 -> account_balance = deposit(account_balance);
                    case 4 -> exit();
                    default -> System.out.println("ONLY 4 OPTION");
                }
               }catch (Exception e){
                   System.out.println("INVALID INPUT");
                   scan.next();
               }
            }
        }
    }
    private static void balance(double a){

        System.out.printf("your account balance is ₹ %.2f\n",a);
        System.out.println("\uD83D\uDD10 Returning to PIN entry for security...");
    }
    private static double withdraw(double a){
        try{
            System.out.print("enter the amount to withdraw:");
            double amount = scan.nextDouble();

            if (a > amount && a >= 500) {
                a -= amount;
                System.out.printf("\nthe amount %.2f withdrawn successfully", amount);
                System.out.printf("\nyour current account balance is ₹ %.2f", a);

            }if (a < amount) {
                System.out.println("INVALID BALANCE");
            }if (a <= 500) {
                System.out.println("MINIMUM BALANCE REQUIRED");
            }
            System.out.println("\uD83D\uDD10 Returning to PIN entry for security....");
        }catch (InputMismatchException e)
        {
            System.out.println("INVALID INPUT ONLY NUMBERS");
            scan.next();
        }return a;
    }
    private static double deposit(double a){

       try {
            System.out.print("enter a amount to deposit : ");
            double amount = scan.nextDouble();
            if (amount > 0) {
                a += amount;
                System.out.println("your account balance " + a);
            } else {
                System.out.println("ENTER A VALID AMOUNT");
            }
           System.out.println("\uD83D\uDD10 Returning to PIN entry for security....");

        }catch (InputMismatchException e)
       {
           System.out.println("INVALID INPUT ONLY NUMBERS");
           scan.next();
       }
        return a;
    }
    private static void exit(){
        System.out.println("THANK YOU FOR BANKING WITH US");
        isTrue = false;
    }
}