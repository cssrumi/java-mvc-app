package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.model.Employee;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.services.SessionService;
import com.cssrumi.view.EmployeeView;
import com.cssrumi.view.SessionView;
import com.cssrumi.view.WageView;

public class WageController {

    private EmployeeService employeeService;
    private SessionService sessionService;

    public WageController() {
        this.employeeService = App.getEmployeeService();
        this.sessionService = App.getSessionService();
    }

    public WageController(EmployeeService employeeService, SessionService sessionService) {
        this.employeeService = employeeService;
        this.sessionService = sessionService;
    }

    public void menu() {
        if(sessionService.isAuthorized()) {
            String choice = WageView.menu();
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
                case "s":
                    setWageById();
                    break;
                default:
                    break;
            }
        } else SessionView.unauthorized();
    }

    private void displayAllByLastName() {
        if(sessionService.isAuthorized()) {
            String lastName = EmployeeView.enterLastName();
            WageView.displayAll(employeeService.findAllByLastName(lastName));
        } else SessionView.unauthorized();
    }

    private void displayByLastName() {
        if(sessionService.isAuthorized()) {
            String lastName = EmployeeView.enterLastName();
            WageView.display(employeeService.findByLastName(lastName));
        } else SessionView.unauthorized();
    }

    private void displayById() {
        if(sessionService.isAuthorized()) {
            Long id = EmployeeView.enterId();
            display(employeeService.findById(id));
        } else SessionView.unauthorized();
    }

    public void display(Employee employee) {

        if (sessionService.isAuthorized())
            WageView.display(employee);
        else
            SessionView.unauthorized();
    }

    public void displayAll() {
        if(sessionService.isAuthorized())
            WageView.displayAll(employeeService.findAll());
        else
            SessionView.unauthorized();
    }

    public void setWageById() {
        if(sessionService.isAuthorized()) {
            Long id = EmployeeView.enterId();
            employeeService.findById(id).
                    setWage(WageView.setWage());
        } else SessionView.unauthorized();
    }
}
