/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultilities;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class DataInput {

    public static String getString(String displayMessage) {
        String s;
        System.out.print(displayMessage);
        s = getString();
        return s;
    }

    public static String getString(String displayMessage, String pattern) throws Exception {
        String s;
        do {
            System.out.print(displayMessage);
            s = getString();
            if (!Acceptable.checkStringWithFormat(s, pattern)) {
                System.out.println("Invalid Data! Try Again.");
            } else {
                break;
            }
        } while (true);
        return s;
    }

    public static String getStringWithEnter(String displayMessage, String pattern) throws Exception {
        String s;
        do {
            System.out.print(displayMessage);
            s = getString();
            if (s.equals("")) {
                return s;
            }
            if (!Acceptable.checkStringWithFormat(s, pattern)) {
                System.out.println("Invalid Data! Try Again.");
            } else {
                break;
            }
        } while (true);
        return s;
    }

    public static String getString() {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine().trim();
        return s;
    }

}
