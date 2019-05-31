package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.services.OperationService;
import com.cssrumi.services.SessionService;
import com.cssrumi.view.EmployeeView;
import com.cssrumi.view.OperationView;
import com.cssrumi.view.SessionView;

public class OperationController implements MenuController {

    private EmployeeService employeeService;
    private SessionService sessionService;
    private OperationService operationService;

    public OperationController() {
        employeeService = App.getEmployeeService();
        sessionService = App.getSessionService();
        operationService = App.getOperationService();
    }

    public OperationController(EmployeeService employeeService, SessionService sessionService,
                               OperationService operationService) {
        this.employeeService = employeeService;
        this.sessionService = sessionService;
        this.operationService = operationService;
    }

    @Override
    public void menu() {
        if(sessionService.isAuthorized()) {
            String choice = OperationView.menu();
            switch (choice.toLowerCase()) {
                case "d":
                    displayAll();
                    break;
                case "i":
                    displayById();
                    break;
                case "f":
                    displayAllByEmployeeFullName();
                    break;
                case "e":
                    displayAllByEmployeeId();
                    break;
                case "l":
                    displayAllByEmployeeLastName();
                default:
                    break;
            }
        } else SessionView.unauthorized();
    }

    private void displayAllByEmployeeLastName() {
        if(sessionService.isAuthorized()) {
            String lastName = EmployeeView.enterLastName();
            OperationView.displayAll(employeeService.findAllByLastName(lastName));
        } else SessionView.unauthorized();
    }

    public void displayAllByEmployeeFullName() {
        if(sessionService.isAuthorized()) {
            String fullName = EmployeeView.enterFullName();
            OperationView.displayAll(employeeService.findAllByFullName(fullName));
        } else SessionView.unauthorized();
    }

    public void displayAllByEmployeeId() {
        if(sessionService.isAuthorized()) {
            Long id = EmployeeView.enterId();
            OperationView.display(employeeService.findById(id));
        } else SessionView.unauthorized();
    }

    public void displayById() {
        if (sessionService.isAuthorized())
            operationService.findById(EmployeeView.enterId());
        else SessionView.unauthorized();
    }

    public void displayAll() {
        if(sessionService.isAuthorized()) {
            OperationView.displayAll(employeeService.findAll());
        } else SessionView.unauthorized();
    }
}
