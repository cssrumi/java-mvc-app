package com.cssrumi.view;

import com.cssrumi.model.Employee;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EmployeeView {

    public static String menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Display all - d\n" +
                "Find by id - i\n" +
                "Find by last name - l\n" +
                "Find all by last name - a\n" +
                "Find all by full name - f\n" +
                "Edit fullname by id - s\n" +
                "Enter to return"
        );
        System.out.print("Your choice: ");
        return scan.nextLine();
    }

    public static void display(Employee employee) {
        System.out.println(employee.getId().toString() + " " + employee);
    }

    public static void displayAll(Iterable<Employee> employeeSet) {
        for (Employee employee : employeeSet) {
            System.out.println(employee.getId().toString() + " " + employee);
        }
    }

    public static void displayAllFullName(Iterable<Employee> employeeSet) {
        for (Employee employee : employeeSet) {
            System.out.println(employee);
        }
    }

    public static Long enterId() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter id: ");
        return scan.nextLong();
    }

    public static String enterLastName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter last name: ");
        return scan.nextLine();
    }

    public static String enterFullName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter full name: ");
        return scan.nextLine();
    }
}
