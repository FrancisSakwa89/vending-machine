package com.franco;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;


public class main {
    public static void main(String args[]) {
        double CANDY = 10;
        double SNACK = 50;
        double NUTS = 90;

        double COKE = 25;
        double PEPSI = 35;
        double SODA = 45;
        double balance = 0;
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("What's your name?");
        String a = input.nextLine();
        if (a.length() != 0) {

            System.out.println("Enter option to pay: ");
            System.out.println("1. pay with coins");
            System.out.println("2. pay with dollars");
            int option = Integer.parseInt(input.nextLine());
            int pay = 0;
            switch (option) {
                case 1:
                    System.out.println("Choose the coins you will pay with: \n1.Nickle\n2.Dimes\n3.penny\n4.quarters");
                    int choseCoin = Integer.parseInt(input.nextLine());
                    if (choseCoin == 1) {
                        System.out.println("Enter amount in coins to pay in nickles: ");
                        pay = Integer.parseInt(input.nextLine());

                    } else if (choseCoin == 2) {
                        System.out.println("Enter amount as dimes: ");
                        pay = Integer.parseInt(input.nextLine());
                    }
                    else if (choseCoin == 3) {
                        System.out.println("Enter amount as penny: ");
                        pay = Integer.parseInt(input.nextLine());
                    }
                    else if (choseCoin == 4) {
                        System.out.println("Enter amount as quarters: ");
                        pay = Integer.parseInt(input.nextLine());
                    }
            }
//                    if (pay > 0 && pay < 50 && pay > finalTotal) {
//                        balance += pay - finalTotal;
//                        System.out.println("Your balance is: " + balance);
//                    } else if (pay == finalTotal) {
//                        System.out.println("No balance...");
//                    } else if (pay < finalTotal) {
//                        System.out.println("You provided less amount amount");
//                    }
//                    break;
//
//                case 2:
////                    if (option == 2) {
//                    System.out.println("Enter no of dollars: ");
//                    double lipa = Integer.parseInt(input.nextLine());
//                    double finalipa = (lipa * 100);
//                    if (lipa > 0 && lipa < 50 && finalipa > finalTotal) {
//                        balance += finalipa - finalTotal;
//                        System.out.println("Your balance is: " + balance);
//                    } else if (finalipa == finalTotal) {
//                        System.out.println("No balance...");
//                    } else if (finalipa < finalTotal) {
//                        System.out.println("you provided less amount..");
//                    }

            System.out.println("Welcome to Franco's Market, " + a.toUpperCase() + "  We have the following items for sale:");
            System.out.println("Candy       $10");
            System.out.println("Snack       $50");
            System.out.println("Nuts        $90");
            System.out.println("Coke        $25");
            System.out.println("Pepsi       $35");
            System.out.println("Soda        $45");
            System.out.println("How many candy's do you want?");
            int candy = Integer.parseInt(input.nextLine());
            System.out.println("How many snacks do you want?");
            int snack = Integer.parseInt(input.nextLine());
            System.out.println("What about nuts?");
            int nuts = Integer.parseInt(input.nextLine());
            System.out.println("What about coke?");
            int coke = Integer.parseInt(input.nextLine());
            System.out.println("What about pepsi?");
            int pepsi = Integer.parseInt(input.nextLine());
            System.out.println("What about soda?");
            int soda = Integer.parseInt(input.nextLine());

//new code below
            double candyTotal = (CANDY) * candy;
            double snackTotal = SNACK * snack;
            double nutsTotal = (NUTS) * nuts;
            double cokeTotal = (COKE) * coke;
            double pepsiTotal = PEPSI * pepsi;
            double sodaTotal = SODA * soda;
            double finalTotal = candyTotal + snackTotal + cokeTotal + nutsTotal + pepsiTotal + sodaTotal;
            System.out.println("Your total is: " + finalTotal);
            if (pay > 0 && pay > finalTotal) {
                double balance1 = pay - finalTotal;
                System.out.println("Your balance is: " + balance1);
                System.out.println("Customer Name: "+a);
            } else {

                System.out.println("you provided less amount." + pay);
                System.out.println("Add more cash...");
                double choise2 = Integer.parseInt(input.nextLine());
                double pay2;
                pay2 = pay+choise2;

                if (pay2 > finalTotal) {
                    double balance2 = Double.parseDouble(input.nextLine());
                    System.out.println("your balance is: " + balance2);
                } else if (pay2 == finalTotal) {
                    System.out.println("You have no balance... yet");
                }

            }

        } else System.out.println("Please enter a valid name...");


    }
}

