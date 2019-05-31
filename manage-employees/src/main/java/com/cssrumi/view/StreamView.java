package com.cssrumi.view;

import java.util.Scanner;

public class StreamView {
    public static String menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Sort by last name and first name - q\n" +
                "Display all fullname - w\n" +
                "Display all Employee last name beginning with P - e\n" +
                "Display all Employee with Wage.basic > 5000 - r\n" +
                "Display sum of Employee Wage.basic - t\n" +
                "Sort by Wage.basic - y\n" +
                "Enter to return"
        );
        System.out.print("Your choice: ");
        return scan.nextLine();

    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }
}
