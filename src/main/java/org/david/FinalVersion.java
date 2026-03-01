package org.david;

import java.util.ArrayList;
import java.util.Scanner;

public class FinalVersion {


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        // Hardcoded example data
        ArrayList<String> buildSummary = new ArrayList<>();
        ArrayList<String> cartSummary = new ArrayList<>();

        String cpuSocket = "AM5";
        String motherboardSocket = "AM5";
        String ramType = "DDR5";
        String motherboardSupportedRAMType = "DDR5";
        int totalSystemWattage = 650;
        int psuWattage = 600;
        int inStockAmount = 5;
        // Inventory — 2 parts per category
        String cpu1 = "AMD Ryzen 7 9800X3D — Socket: AM5, $479";
        String cpu2 = "Intel Core i7-14700K — Socket: LGA1700, $389";
        String mb1 = "ASUS ROG Strix X870-E — Socket: AM5, RAM: DDR5, $299";
        String mb2 = "MSI PRO Z790-A — Socket: LGA1700, RAM: DDR5, $199";
        String ram1 = "Corsair Vengeance 32GB DDR5-6000, $89";
        String ram2 = "G.Skill Trident Z5 32GB DDR5-6400, $99";
        String gpu1 = "NVIDIA RTX 4070 Super — 250W TDP, $599";
        String gpu2 = "AMD RX 7800 XT — 263W TDP, $489";
        String storage1 = "Samsung 990 Pro 1TB NVMe SSD, $109";
        String storage2 = "WD Black SN850X 1TB NVMe SSD, $99";
        String psu1 = "Corsair RM850x — 850W, 80+ Gold, $129";
        String psu2 = "EVGA SuperNOVA 750W — 80+ Gold, $109";
        String case1 = "Fractal Design North — Mid Tower, $109";
        String case2 = "Lian Li O11 Dynamic — Mid Tower, $149";
        String cooler1 = "Noctua NH-D15 — Air Cooler, $99";
        String cooler2 = "Corsair H150i Elite — 360mm AIO, $179";
        boolean isCompatibleWithCurrentBuild = true;
        boolean partAlreadyExistsInInventory = false;
        boolean buildSlotIsOccupied = true;

        System.out.println("**---------------------------------------------------------------**");
        System.out.println("Welcome to PC Part Builder and Compatibility Checker by David Griffin!");
        System.out.println("**---------------------------------------------------------------**\n");
        System.out.println("**** Let's build your dream PC! ****\n");

        // Outer while loop — keeps program running until user quits
        char modeSelection = ' ';
        while (modeSelection != 'Q' && modeSelection != 'q') {

            // Flowchart 1 — switch: Main Menu
            System.out.print("- Select Mode: (B)uild System, (S)hop Parts, (A)dd Inventory, or (Q)uit: ");
            modeSelection = scnr.next().charAt(0);
            switch (modeSelection) {
                case 'B':
                case 'b':
                    System.out.println("Entering Build System mode...\n");
                    break;
                case 'S':
                case 's':
                    System.out.println("Entering Shop Parts mode...\n");
                    break;
                case 'A':
                case 'a':
                    System.out.println("Entering Add Inventory mode...\n");
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.\n");
            }

            // BUILD MODE
            if (modeSelection == 'B' || modeSelection == 'b') {
                char buildAction = 'A';
                while (buildAction != 'C' && buildAction != 'c') {

                    // Flowchart 2 — switch: Part Category Selection
                    System.out.print(
                            "Select a part category (1=CPU 2=Motherboard 3=RAM 4=GPU 5=Storage 6=PSU 7=Case 8=Cooler): ");
                    int categorySelection = scnr.nextInt();
                    int partSelection;
                    String selectedPart = "Unknown Part";
                    switch (categorySelection) {
                        case 1:
                            System.out.println("CPUs:\n  [1] " + cpu1 + "\n  [2] " + cpu2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = cpu1;
                            } else {
                                selectedPart = cpu2;
                            }
                            break;
                        case 2:
                            System.out.println("Motherboards:\n  [1] " + mb1 + "\n  [2] " + mb2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = mb1;
                            } else {
                                selectedPart = mb2;
                            }
                            break;
                        case 3:
                            System.out.println("RAM:\n  [1] " + ram1 + "\n  [2] " + ram2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = ram1;
                            } else {
                                selectedPart = ram2;
                            }
                            break;
                        case 4:
                            System.out.println("GPUs:\n  [1] " + gpu1 + "\n  [2] " + gpu2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = gpu1;
                            } else {
                                selectedPart = gpu2;
                            }
                            break;
                        case 5:
                            System.out.println("Storage:\n  [1] " + storage1 + "\n  [2] " + storage2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = storage1;
                            } else {
                                selectedPart = storage2;
                            }
                            break;
                        case 6:
                            System.out.println("PSUs:\n  [1] " + psu1 + "\n  [2] " + psu2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = psu1;
                            } else {
                                selectedPart = psu2;
                            }
                            break;
                        case 7:
                            System.out.println("Cases:\n  [1] " + case1 + "\n  [2] " + case2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = case1;
                            } else {
                                selectedPart = case2;
                            }
                            break;
                        case 8:
                            System.out.println("Coolers:\n  [1] " + cooler1 + "\n  [2] " + cooler2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = cooler1;
                            } else {
                                selectedPart = cooler2;
                            }
                            break;
                        default:
                            System.out.println("Invalid category selection.");
                    }
                    System.out.println("You selected: " + selectedPart + "\n");

                    // Flowchart 3 — if-else-if: Motherboard Compatibility Check
                    System.out.println("-- Motherboard Compatibility Check --");
                    if (!cpuSocket.equals(motherboardSocket)) {
                        System.out.println("Incompatible: CPU socket does not match motherboard socket.");
                    } else if (!ramType.equals(motherboardSupportedRAMType)) {
                        System.out.println("Incompatible: RAM type not supported by this motherboard.");
                    } else {
                        System.out.println("Compatible — proceed to add to build.");
                    }

                    // Flowchart 4 — if: PSU Wattage Check
                    System.out.println("\n-- PSU Wattage Check --");
                    if (totalSystemWattage > psuWattage) {
                        System.out.println(
                                "Warning: Total system power draw exceeds PSU wattage. Consider upgrading your PSU.");
                    }

                    // Flowchart 5 — if-else with nested: Add Part (Build Mode)
                    System.out.println("\n-- Add Part: Build Mode --");
                    System.out.print("- Please enter the quantity: ");
                    int selectedQuantity = scnr.nextInt();
                    if (selectedQuantity <= inStockAmount) {
                        if (isCompatibleWithCurrentBuild) {
                            buildSummary.add(selectedPart);
                            System.out.println("The part has been added to build!");
                        } else {
                            System.out.println("The part is not compatabile.");
                        }
                    } else {
                        System.out.println("Out of stock. Only " + inStockAmount + " units available.");
                    }

                    // Flowchart 8 — if-else: Remove / Replace Part from Build
                    System.out.println("\n-- Remove / Replace Part from Build --");
                    if (buildSlotIsOccupied) {
                        System.out.println("Current part displayed. Prompting to replace or remove.");
                    } else {
                        System.out.println("No part in this slot. Nothing to remove.");
                    }

                    // Display current build summary
                    System.out.println("\n-- Current Build Summary --");
                    if (buildSummary.isEmpty()) {
                        System.out.println("  (no parts added yet)");
                    } else {
                        for (int i = 0; i < buildSummary.size(); i++) {
                            System.out.println("  [" + (i + 1) + "] " + buildSummary.get(i));
                        }
                    }

                    System.out.print("\n- Add another part (A) or Checkout (C)? ");
                    buildAction = scnr.next().charAt(0);
                }

                // Flowchart 9 — if-else: Checkout (Build Mode)
                System.out.println("\n-- Checkout: Your Build --");
                for (int i = 0; i < buildSummary.size(); i++) {
                    System.out.println("  [" + (i + 1) + "] " + buildSummary.get(i));
                }
                System.out.print("- Confirm checkout? Type \"true\" (Yes) or \"false\" (No): ");
                boolean buildCheckout = scnr.nextBoolean();
                if (buildCheckout) {
                    System.out.println("Build confirmed! Thank you for your order!");
                    buildSummary.clear();
                } else {
                    System.out.println("Checkout cancelled. Returning to main menu.");
                }

                // --- SHOP MODE ---
            } else if (modeSelection == 'S' || modeSelection == 's') {
                char shopAction = 'A';
                while (shopAction != 'C' && shopAction != 'c') {

                    // Flowchart 2 — switch: Part Category Selection
                    System.out.print(
                            "Select a part category (1=CPU 2=Motherboard 3=RAM 4=GPU 5=Storage 6=PSU 7=Case 8=Cooler): ");
                    int categorySelection = scnr.nextInt();
                    int partSelection;
                    String selectedPart = "Unknown Part";
                    switch (categorySelection) {
                        case 1:
                            System.out.println("CPUs:\n  [1] " + cpu1 + "\n  [2] " + cpu2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = cpu1;
                            } else {
                                selectedPart = cpu2;
                            }
                            break;
                        case 2:
                            System.out.println("Motherboards:\n  [1] " + mb1 + "\n  [2] " + mb2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = mb1;
                            } else {
                                selectedPart = mb2;
                            }
                            break;
                        case 3:
                            System.out.println("RAM:\n  [1] " + ram1 + "\n  [2] " + ram2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = ram1;
                            } else {
                                selectedPart = ram2;
                            }
                            break;
                        case 4:
                            System.out.println("GPUs:\n  [1] " + gpu1 + "\n  [2] " + gpu2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = gpu1;
                            } else {
                                selectedPart = gpu2;
                            }
                            break;
                        case 5:
                            System.out.println("Storage:\n  [1] " + storage1 + "\n  [2] " + storage2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = storage1;
                            } else {
                                selectedPart = storage2;
                            }
                            break;
                        case 6:
                            System.out.println("PSUs:\n  [1] " + psu1 + "\n  [2] " + psu2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = psu1;
                            } else {
                                selectedPart = psu2;
                            }
                            break;
                        case 7:
                            System.out.println("Cases:\n  [1] " + case1 + "\n  [2] " + case2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = case1;
                            } else {
                                selectedPart = case2;
                            }
                            break;
                        case 8:
                            System.out.println("Coolers:\n  [1] " + cooler1 + "\n  [2] " + cooler2);
                            System.out.print("- Select a part [1] or [2]: ");
                            partSelection = scnr.nextInt();
                            if (partSelection == 1) {
                                selectedPart = cooler1;
                            } else {
                                selectedPart = cooler2;
                            }
                            break;
                        default:
                            System.out.println("Invalid category selection.");
                    }
                    System.out.println("You selected: " + selectedPart);

                    // Flowchart 6 — if-else: Add Part (Shop Mode)
                    System.out.println("\n-- Add Part: Shop Mode --");
                    System.out.print("- Please enter the quantity: ");
                    int selectedQuantity = scnr.nextInt();
                    if (selectedQuantity <= inStockAmount) {
                        cartSummary.add(selectedPart);
                        System.out.println("Part added to cart!");
                    } else {
                        System.out.println("Insufficient stock. Only " + inStockAmount + " units available.");
                    }

                    // Display current cart
                    System.out.println("\n-- Current Cart --");
                    if (cartSummary.isEmpty()) {
                        System.out.println("  (cart is empty)");
                    } else {
                        for (int i = 0; i < cartSummary.size(); i++) {
                            System.out.println("  [" + (i + 1) + "] " + cartSummary.get(i));
                        }
                    }

                    System.out.print("\n- Add another item (A) or Checkout (C)? ");
                    shopAction = scnr.next().charAt(0);
                }

                // Flowchart 9 — if-else: Checkout (Shop Mode)
                System.out.println("\n-- Checkout: Your Cart --");
                for (int i = 0; i < cartSummary.size(); i++) {
                    System.out.println("  [" + (i + 1) + "] " + cartSummary.get(i));
                }
                System.out.print("- Confirm checkout? Type \"true\" (Yes) or \"false\" (No): ");
                boolean shopCheckout = scnr.nextBoolean();
                if (shopCheckout) {
                    System.out.println("Checked out! Thank you!");
                    cartSummary.clear();
                } else {
                    System.out.println("Not checking out. Back to main menu.");
                }

                // --- ADD INVENTORY MODE ---
            } else if (modeSelection == 'A' || modeSelection == 'a') {
                // Flowchart 7 — if-else: Add Inventory
                System.out.println("-- Add Inventory --");
                if (partAlreadyExistsInInventory) {
                    System.out.println("Part already exists in inventory. Updating stock quantity.");
                } else {
                    System.out.println("New inventory entry created with all part details.");
                }
            }

            System.out.println();
        }

        System.out.println("End of Program");
    }

}
