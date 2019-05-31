package com.cssrumi.view;

import java.util.Scanner;

public class MainView {
    public static String mainMenu(boolean isAuthorized) {
        Scanner scan = new Scanner(System.in);
        if(isAuthorized)
            System.out.println(
                    "Employee - e\n" +
                    "Wage - w\n" +
                    "Contract - c\n" +
                    "Operation - o\n" +
                    "User - u\n" +
                    "Logout - l\n" +
                    "Stream API (LINQ) - s\n" +
                    "Exit - x");
        else
            System.out.println(
                    "Employee - e\n" +
                    "Wage - w\n" +
                    "Contract - c\n" +
                    "Operation - o\n" +
                    "User - u\n" +
                    "Login - l\n" +
                    "Stream API (LINQ) - s\n" +
                    "Exit - x");
        System.out.print("Choice: ");
        return scan.nextLine();
    }
}
