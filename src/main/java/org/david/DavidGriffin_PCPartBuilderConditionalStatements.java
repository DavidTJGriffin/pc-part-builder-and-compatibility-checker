package org.david;

import java.util.Scanner;

/*
 * Author: David Griffin
 * Date: 02/27/2026
 * Course and Section Number: CSC110AB 11163
 * Program Name: PC Part Builder and Compatibility Checker
 * Program Purpose:
 * The purpose of this program is to be an inventory management system of various different PC parts.
 * The program will let you choose parts and add them to your builder to check for compatability. Choose the parts you want and build you dream system!
 * Then after the builder phase you can calculate totals & check out.
 *
 * This class specifically demonstrates conditional statement logic for a PC part builder system covering the essential flows.
 */

public class DavidGriffin_PCPartBuilderConditionalStatements {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // example data
        String cpuSocket = "AM5";
        String motherboardSocket = "AM5";
        String ramType = "DDR5";
        String motherboardSupportedRAMType = "DDR5";
        int totalSystemWattage = 650;
        int psuWattage = 600;
        int inStockAmount = 5;
        boolean isCompatibleWithCurrentBuild = true;
        boolean partAlreadyExistsInInventory = false;
        boolean buildSlotIsOccupied = true;

        System.out.println("**---------------------------------------------------------------**");
        System.out.println("Welcome to PC Part Builder and Compatibility Checker by David Griffin!");
        System.out.println("**---------------------------------------------------------------**\n");

        // While loop for main program and mode selection. User presses 'q' or 'Q' to
        // quite
        char modeSelection = ' ';
        while (modeSelection != 'Q' && modeSelection != 'q') {

            // Flowchart 1 - switch: Main Menu
            System.out.print("- Select Mode: (B)uild System, (S)hop Parts, (A)dd Inventory, or (Q)uit: ");
            modeSelection = scnr.next().charAt(0);
            System.out.println("You entered: " + modeSelection + "\n");
            switch (modeSelection) {
                case 'B':
                case 'b':
                    System.out.println("Entering Build System mode...");
                    break;
                case 'S':
                case 's':
                    System.out.println("Entering Shop Parts mode...");
                    break;
                case 'A':
                case 'a':
                    System.out.println("Entering Add Inventory mode...");
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

            // Build and Shop modes cateogry selection
            if (modeSelection == 'B' || modeSelection == 'b' || modeSelection == 'S' || modeSelection == 's') {

                // Flowchart 2 - switch: Part Category Selection
                System.out.print(
                        "\nSelect a part category (1=CPU 2=Motherboard 3=RAM 4=GPU 5=Storage 6=PSU 7=Case 8=Cooler): ");
                int categorySelection = scnr.nextInt();
                switch (categorySelection) {
                    case 1:
                        System.out.println("Displaying CPU inventory list.");
                        break;
                    case 2:
                        System.out.println("Displaying Motherboard inventory list.");
                        break;
                    case 3:
                        System.out.println("Displaying RAM inventory list.");
                        break;
                    case 4:
                        System.out.println("Displaying GPU inventory list.");
                        break;
                    case 5:
                        System.out.println("Displaying Storage inventory list.");
                        break;
                    case 6:
                        System.out.println("Displaying PSU inventory list.");
                        break;
                    case 7:
                        System.out.println("Displaying Case inventory list.");
                        break;
                    case 8:
                        System.out.println("Displaying Cooler inventory list.");
                        break;
                    default:
                        System.out.println("Invalid category selection.");
                }

                if (modeSelection == 'B' || modeSelection == 'b') {
                    // Flowchart 3 - if-else-if: Motherboard Compatibility Check
                    System.out.println("\n-- Motherboard Compatibility Check --");
                    if (!cpuSocket.equals(motherboardSocket)) {
                        System.out.println("Incompatible: CPU socket does not match motherboard socket.");
                    } else if (!ramType.equals(motherboardSupportedRAMType)) {
                        System.out.println("Incompatible: RAM type not supported by this motherboard.");
                    } else {
                        System.out.println("Part is compatible with motherboard - proceed to add to build.");
                    }

                    // Flowchart 4 - if: PSU Wattage Check
                    System.out.println("\n-- PSU Wattage Check --");
                    if (totalSystemWattage > psuWattage) {
                        System.out.println(
                                "Warning: Total system power draw exceeds PSU wattage. Consider upgrading your PSU.");
                    }

                    // Flowchart 5 - if-else with nested conditional: Add Part (Build Mode)
                    System.out.println("\n-- Add Part: Build Mode --");
                    System.out.print("- Please enter the quantity of the item: ");
                    int selectedQuantity = scnr.nextInt();
                    System.out.println("You selected " + selectedQuantity + " item(s).");
                    if (selectedQuantity <= inStockAmount) {
                        if (isCompatibleWithCurrentBuild) {
                            System.out.println("Part added to build. Build summary updated successfully.");
                        } else {
                            System.out.println("Compatibility error: part not added to build.");
                        }
                    } else {
                        System.out.println("Insufficient stock. Only " + inStockAmount + " units available.");
                    }

                    // Flowchart 8 - if-else: Remove / Replace Part from Build
                    System.out.println("\n-- Remove / Replace Part from Build --");
                    if (buildSlotIsOccupied) {
                        System.out.println(
                                "Current part displayed. Prompting to replace or remove. Build summary updated.");
                    } else {
                        System.out.println("No part in this slot. Nothing to remove.");
                    }

                } else {
                    // Flowchart 6 - if-else: Add Part (Shop Mode)
                    System.out.println("\n-- Add Part: Shop Mode --");
                    System.out.print("- Please enter the quantity of the item: ");
                    int selectedQuantity = scnr.nextInt();
                    System.out.println("You selected " + selectedQuantity + " item(s).");
                    if (selectedQuantity <= inStockAmount) {
                        System.out.println("Part added to cart. Cart total updated.");
                    } else {
                        System.out.println("Insufficient stock. Only " + inStockAmount + " units available.");
                    }

                    // Flowchart 9 - if-else: Checkout
                    System.out.println("\n-- Checkout --");
                    System.out.print("- Confirm checkout? Type \"true\" (Yes) or \"false\" (No): ");
                    boolean userConfirmsCheckout = scnr.nextBoolean();
                    if (userConfirmsCheckout) {
                        System.out.println("Checked out! Thank you!");
                    } else {
                        System.out.println("Checkout cancelled. Returning to main menu.");
                    }
                }

            } else if (modeSelection == 'A' || modeSelection == 'a') {
                // Flowchart 7 - if-else: Add Inventory
                System.out.println("\n-- Add Inventory --");
                if (partAlreadyExistsInInventory) {
                    System.out.println("Part already exists in inventory. Updating stock quantity.");
                } else {
                    System.out.println("New inventory entry created with all part details.");
                }
            }

            System.out.println();
        }

        System.out.println("End of Program");

        /*
         * I learned a lot in this lesson. Without conditional statements, a program practically
         * doesn't exist. So much of the user experience depends on being able to interact with
         * data in different ways conditionally, and that's exactly what the PC Part Builder and
         * Compatibility Checker does.
         *
         * I've implemented all of my flowcharts, and since I've been working through Chapter 4,
         * I'm also familiar with loops. That's reinforced by my CSC 205AA class, which I'm taking
         * in parallel and where we're covering more advanced Java concepts. I added a while loop
         * for the mode selection. Right now, the program moves sequentially or conditionally through
         * the different modes, but there isn't much functionality around actually storing user data.
         * There are no real items or inventory yet, but the main flows are in place to support that
         * additional functionality later.
         *
         * For inventory, I want to use arrays for appending and removing items and checking quantities.
         * I might also implement a hash map where the key is the item name and the value is the quantity.
         * That logic is out of scope for this conditional phase though. The goal here was to get the
         * main flows in place, and also to improve error handling. Right now, if the user enters invalid
         * data the program just halts and exits. I want a while loop that catches invalid input, prompts
         * the user to try again, and explains why their input wasn't accepted.
         *
         * The main structure uses switch-case statements for the menu, and then outer if statements
         * matching each case for the mode. Within that is an if-else chain for each mode's logic.
         * It made the most sense to group the part category selection logic with build mode and shop
         * mode, since both involve parts.
         *
         * In the future I want to add cart functionality in build mode so users can add items and see
         * totals. There are more logic features to build out, but I wanted to get the core conditional
         * flows in first. One thing I noticed is that nesting conditional statements can get complex
         * fast, so I do want to go back and refactor. I also installed a plugin on IntelliJ called
         * Rainbow Brackets, which has been really helpful for visualizing which code blocks belong
         * together.
         *
         * I'm excited to add arrays and more functionality. I actually want to pull real data from
         * the internet, or a local copy of it, for inventory, so that the app has real items, real
         * prices, and real compatibility checks. The goal is a well-featured, full command-line application.
         *
         * Sources I used were Zybooks, Baeldung, and my CSC 205AA class.
         */
    }
}
