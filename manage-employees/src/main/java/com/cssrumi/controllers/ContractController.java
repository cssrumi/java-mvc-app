package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.Logger;
import com.cssrumi.model.Contract;
import com.cssrumi.model.Employee;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.services.SessionService;
import com.cssrumi.view.ContractView;
import com.cssrumi.view.EmployeeView;
import com.cssrumi.view.SessionView;
import com.cssrumi.view.WageView;

public class ContractController implements MenuController {

    private EmployeeService employeeService;
    private SessionService sessionService;

    public ContractController() {
        this.employeeService = App.getEmployeeService();
        this.sessionService = App.getSessionService();
    }

    public ContractController(EmployeeService employeeService, SessionService sessionService) {
        this.employeeService = employeeService;
        this.sessionService = sessionService;
    }

    @Override
    public void menu() {
        if(sessionService.isAuthorized()) {
            String choice = ContractView.menu();
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
                    setContractById();
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
            ContractView.display(employee);
        else
            SessionView.unauthorized();
    }

    public void displayAll() {
        if(sessionService.isAuthorized())
            ContractView.displayAll(employeeService.findAll());
        else
            SessionView.unauthorized();
    }

    public void setContractById() {
        if(sessionService.isAuthorized()) {
            Long id = EmployeeView.enterId();
            int contractId = ContractView.setContract();

            if (0 <= contractId && contractId < Contract.values().length)
                employeeService.findById(id).
                        setContract(Contract.values()[contractId]);
            else
                Logger.error("Invalid Contract id - " + contractId);
        } else SessionView.unauthorized();
    }
}
