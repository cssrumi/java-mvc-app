package com.cssrumi.view;

import com.cssrumi.model.Employee;
import com.cssrumi.model.Wage;

import java.util.Scanner;
import java.util.Set;

public class WageView {

    public static String menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Display all - d\n" +
                "Find by id - i\n" +
                "Find by last name - l\n" +
                "Find all by last name - a\n" +
                "Enter to return"
        );
        System.out.print("Your choice: ");
        return scan.nextLine();
    }

    public static void displayAll(Set<Employee> employeeSet) {
        for (Employee employee: employeeSet){
            display(employee);
        }
    }

    public static void display(Employee employee) {
        Wage wage = employee.getWage();
        if(wage != null)
            System.out.println(
                    employee + "\n" +
                    "Basic: " + wage.basic + "\n" +
                    "Bonus: " + wage.bonus + "\n" +
                    "Other: " + wage.other
            );
        else System.out.println("Wage is empty");
    }
}
