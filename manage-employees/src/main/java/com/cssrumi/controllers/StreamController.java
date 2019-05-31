package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.model.Employee;
import com.cssrumi.model.Person;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.view.EmployeeView;
import com.cssrumi.view.StreamView;

import java.util.Comparator;
import java.util.stream.Collectors;

public class StreamController implements MenuController {

    private EmployeeService employeeService;

    public StreamController() {
        employeeService = App.getEmployeeService();
    }

    public StreamController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void menu() {
        String choice = StreamView.menu();
        switch (choice.toLowerCase()) {
            case "d":
                displayAllSortedByName();
                break;
            case "i":
                App.getEmployeeController().displayAll();
                break;
            case "l":
                displayAllBeginningWith('P');
                break;
            case "a":
                displayAllWithWageBiggerThan(5000f);
                break;
            case "f":
                displaySumOfAll();
                break;
            case "s":
                displayAllSortedByWage();
                break;
            default:
                break;
        }
    }

    private void displayAllSortedByWage() {
        EmployeeView.displayAll(
                employeeService
                        .findAll()
                        .stream()
                        .sorted(Employee::compareTo)
                        .collect(Collectors.toList())
        );
    }

    private void displaySumOfAll() {
        double sum = employeeService
                .findAll()
                .stream()
                .mapToDouble(Employee::toDouble)
                .sum();
        StreamView.displayMessage(
                "Sum of Wage: " + sum
                );
    }

    private void displayAllWithWageBiggerThan(float value) {
        EmployeeView
                .displayAll(
                        employeeService
                                .findAll()
                                .stream()
                                .filter(employee -> employee.getWage().basic > value)
                                .collect(Collectors.toList())
                );
    }

    private void displayAllBeginningWith(char c) {
        EmployeeView
                .displayAll(
                        employeeService
                                .findAll()
                                .stream()
                                .filter(employee -> employee.getLastName() != null)
                                .filter(employee -> employee.getLastName().charAt(0) == c)
                                .collect(Collectors.toList())
                );
    }

    private void displayAllSortedByName() {
        EmployeeView.displayAll(
                employeeService
                        .findAll()
                        .stream()
                        .sorted(Comparator.comparing(Person::getFirstName))
                        .sorted(Comparator.comparing(Person::getLastName))
                        .collect(Collectors.toList())
        );
    }
}
