package com.cssrumi.view;


import com.cssrumi.model.User;

import java.util.Scanner;
import java.util.Set;

public class UserView {


    public static String menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Display all - d\n" +
                "Enter to return"
        );
        System.out.print("Your choice: ");
        return scan.nextLine();
    }

    public static void displayAll(Set<String> all) {
        for (String login: all) {
            System.out.println(login);
        }
    }
}
