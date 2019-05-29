package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.view.EmployeeView;

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = App.getEmployeeService();
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void menu() {
        String choice = EmployeeView.menu();
        switch (choice.toLowerCase()) {
            case "d":
                displayAll();
                break;
            case "i":
                displayById();
                break;
            case "l":
                displayByLastName();
                break;
            case "a":
                displayAllByLastName();
                break;
            case "f":
                displayAllByFullName();
                break;
            default:
                break;
        }
    }

    private void displayAllByFullName() {
        String fullName = EmployeeView.enterFullName();
        EmployeeView.displayAll(employeeService.findAllByFullName(fullName));
    }

    public void displayByLastName() {
        String lastName = EmployeeView.enterLastName();
        EmployeeView.display(employeeService.findByLastName(lastName));
    }

    public void displayAllByLastName() {
        String lastName = EmployeeView.enterLastName();
        EmployeeView.displayAll(employeeService.findAllByLastName(lastName));
    }

    public void displayById() {
        Long id = EmployeeView.enterId();
        EmployeeView.display(employeeService.findById(id));
    }

    public void displayAll() {
        EmployeeView.displayAll(employeeService.findAll());
    }
}
