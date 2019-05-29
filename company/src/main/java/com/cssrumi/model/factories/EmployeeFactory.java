package com.cssrumi.model.factories;

import com.cssrumi.model.Contract;
import com.cssrumi.model.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeFactory {

    public static Employee getEmployee(String firstName, String lastName) {
        return new Employee(firstName, lastName);
    }

    public static Employee getEmployeeByFullName(String fullName) {
        List<String> names = Arrays.asList(fullName.split(" "));
        if (names.size() >= 2) {
            return new Employee(names.get(0), names.get(1));
        } else return null;
    }

    public static Employee getEmployeeWithContract(String firstName, String lastName, Contract contract) {
        Employee employee = new Employee(firstName, lastName);
        employee.setContract(contract);
        return employee;
    }
}
