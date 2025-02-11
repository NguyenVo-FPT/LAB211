/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Ultilities.Acceptable;
import Ultilities.DataInput;
import java.io.IOException;

/**
 *
 * @author nguye
 */
public class Menu {

    public static String getUserChoice() {
        String choice = "";
        try {
            choice = DataInput.getString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choice;
    }

    public static void exitProgram() throws Exception {
        String selections = DataInput.getString("Do you want to save the changes before exiting? (Y/N): ", Acceptable.CHOICE_VALID);

        if (selections.equalsIgnoreCase("Y")) {
            System.exit(0);
        } else if (selections.equalsIgnoreCase("N")){
            return;
        } else {
            System.out.println("Invalid Choice!");
        }
    }

    public static void printMenu() {
        System.out.println("********************Main Menu\"********************");
        System.out.println("1. New Registration \n"
                         + "2. Update Registration Information \n"
                         + "3. Display Registered List\n"
                         + "4. Delete Registration Information \n"
                         + "5. Search Participants by Name\n"
                         + "6. Filter Data by Campus \n"
                         + "7. Statistics of Registration Numbers by Location\n"
                         + "8. Save Data to File \n"
                         + "9. Exit the Program");
        System.out.print("Select: ");
    }

    public static void pause() throws IOException {
        System.out.println("Enter to return Main Menu!!");
        System.in.read();
        System.out.println("Returning to Main Menu...");
    }
}
