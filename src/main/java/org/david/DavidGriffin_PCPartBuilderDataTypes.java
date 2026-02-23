package org.david;

import java.util.Scanner;

/**
 * Author: David Griffin
 * Date: 02/07/2026
 * Course and Section Number: CSC110AB 11163
 * Program Name: PC Part Builder and Compatability Checker
 *
 * The purpose of this program is to be an inventory management system of various different PC parts.
 * The program will let you choose parts and add them to your builder to check for compatability. Choose the parts you want and build you dream system!
 * Then after the builder phase you can calculate totals & check out.
 */

public class DavidGriffin_PCPartBuilderDataTypes {

    public static void main(String[] args) {
        boolean checkOutIndicator;
        int quantityOfItem;
        double componentPrice;
        String computerPartCategory;
        char modeSelection;

        Scanner scnr = new Scanner(System.in);
        // Mode Selection user prompt
        System.out.println("**** Welcome to PC Part Picker and Compatability Checker, let's build your dream PC! ****\n");
        System.out.print("- Select Mode: (B)uild System, (S)hop Parts, or (Q)uit: ");
        modeSelection = scnr.next().charAt(0);
        System.out.println("Your entered: " + modeSelection + "\n");

        if (modeSelection == 'B' || modeSelection == 'b') {
            System.out.println("Entering Build System mode... ");
        } else if (modeSelection == 'S' || modeSelection == 's') {
            System.out.println("Entering Shop Parts mode... ");
        } else if (modeSelection == 'Q' || modeSelection == 'q') {
            System.out.println("Quitting program... ");
        }

        // PC Part Category Picker user prompt
        System.out.print("\n- Let's get building! Please enter the computer part type category you want to select parts for (CPUs, motherboards, RAM, storage (SSD/HDD), GPUs, power supplys, cases, CPU coolers): ");
        computerPartCategory = scnr.next();
        System.out.println("You selected " + computerPartCategory + ". Here is our inventory of " + computerPartCategory + ":");

        // Quantity selction user prompt
        System.out.print("\n- Please enter the quantity of the items: ");
        quantityOfItem = scnr.nextInt();
        System.out.println("You selected " + quantityOfItem + " items.");

        // Enter price for inventory user prompt
        System.out.print("\nPlease enter the price of this component: ");
        componentPrice = scnr.nextDouble();
        System.out.println("Your component price is: $" + componentPrice);

        // Checkout confirmation user prompt
        System.out.print("\n- Would you like to confirm your order and checkout? Type \"True\" (Yes) or \"False\" (No): ");
        checkOutIndicator = scnr.nextBoolean();

        if (checkOutIndicator) {
            System.out.println("You entered " + checkOutIndicator + ".");
            System.out.println("Checking out now");
        } else  {
            System.out.println("You entered " + checkOutIndicator + ".");
            System.out.println("Not checking out now!");
        }

        System.out.println("\nEnd of Program");

        // What I learned:
        // I learned a lot in this lesson, specifically about the different data types in Java.
        // Java is a language that is strongly typed, which means that variables have to have an associated data type with them.
        // Some of the data types are primitives and some of them are non-primitives, such as String.
        // I also learned how to get user input using the Scanner class in Java and assigning that user input to a variable to then use in logic.
        // At the heart of programming or systematic thinking is data and essentially what programs are is just logic applied to various different forms of data.
        // Most programs are essentially transformations of data - Input > Process > Output.
        // In this program it is - user input from Scanner > various logic > outputting user data based on various logic.

        // Resources I used:
        // https://www.baeldung.com/get-started-with-java-series, ZyBooks
    }


}
