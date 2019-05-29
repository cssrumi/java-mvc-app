package com.cssrumi.view;

import java.util.HashMap;
import java.util.Scanner;

public class SessionView {
    public static HashMap<String, String> authorize(){
        HashMap<String, String> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("login: ");
        map.put("login", scan.next());

        System.out.print("password: ");
        map.put("password", scan.next());

        return map;
    }

    public static void unauthorized() {
        System.out.println("Unauthorized...");
    }

    public static void authorized() {
        System.out.println("Authorized...");
    }
}
