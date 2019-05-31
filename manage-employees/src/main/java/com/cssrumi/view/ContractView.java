package com.cssrumi.view;

import com.cssrumi.model.Contract;
import com.cssrumi.model.Employee;

import java.util.Scanner;
import java.util.Set;

public class ContractView {

    private static StringBuffer stringBuffer = new StringBuffer();

    public static String menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Display all - d\n" +
                "Find by id - i\n" +
                "Find by last name - l\n" +
                "Find all by last name - a\n" +
                "Set Wage by id - s\n" +
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
        Contract contract = employee.getContract();
        if(contract != null)
            System.out.println(
                    employee + "\n" +
                    "Contract: " + contract
            );
        else
            System.out.println(
                employee + "\n" +
                "Contract is empty"
            );
    }

    public static int setContract() {
        Scanner scan = new Scanner(System.in);
        for(Contract contract: Contract.values()) {
            stringBuffer
                    .append(contract.getId())
                    .append(": ")
                    .append(contract.toString())
                    .append(", ");
        }

        System.out.println(
                "Select one of the Contract types: \n" +
                stringBuffer.toString().substring(0, stringBuffer.toString().length() - 2)
        );
        stringBuffer.setLength(0);

        return scan.nextInt();
    }

}
