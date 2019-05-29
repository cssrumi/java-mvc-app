package com.cssrumi.view;

import com.cssrumi.model.Employee;
import com.cssrumi.model.Operation;

import java.util.Scanner;
import java.util.Set;

public class OperationView {

    public static String menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Display all - d\n" +
                        "Find by id - i\n" +
                        "Find by full name - f\n" +
                        "Find by employee id - e\n" +
                        "Find by last name - l\n" +
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
        Set<Operation> operations = employee.getOperations();
        if(operations.size() > 0) {
            System.out.println(employee + ":");
            operations.forEach(System.out::println);
        } else System.out.println(employee + " has no operations");
    }
}
