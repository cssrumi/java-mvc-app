package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.Logger;
import com.cssrumi.model.Employee;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.services.SessionService;
import com.cssrumi.view.ContractView;
import com.cssrumi.view.EmployeeView;
import com.cssrumi.view.SessionView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeController implements MenuController {

    private EmployeeService employeeService;
    private SessionService sessionService;

    public EmployeeController() {
        this.employeeService = App.getEmployeeService();
        this.sessionService = App.getSessionService();
    }

    public EmployeeController(EmployeeService employeeService, SessionService sessionService) {
        this.employeeService = employeeService;
        this.sessionService = sessionService;
    }

    @Override
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
            case "s":
                setEmployeeFullName();
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

    public void setEmployeeFullName() {
        if (sessionService.isAuthorized()) {
            Long id = EmployeeView.enterId();
            String newFullName = EmployeeView.enterFullName();
            Employee employee = employeeService.findById(id);
            List<String> names = Stream
                    .of(newFullName.split("\\s"))
                    .collect(Collectors.toList());
            if (names.size() > 1) {
                employee.setFirstName(names.get(0));
                employee.setLastName(names.get(1));
            } else
                Logger.error("Invalid name - " + newFullName);
        } else SessionView.unauthorized();
    }
}
