package com.cssrumi;

import com.cssrumi.observer.EmployeeObserver;
import com.cssrumi.bootstrap.DataLoader;
import com.cssrumi.controllers.*;
import com.cssrumi.services.*;
import com.cssrumi.services.map.EmployeeServiceMap;
import com.cssrumi.services.map.OperationServiceMap;
import com.cssrumi.services.map.UserServiceMap;

public class App {

    private static OperationService operationService;
    private static EmployeeService employeeService;
    private static UserService userService;
    private static SessionService sessionService;
    private static MainController mainController;
    private static EmployeeController employeeController;
    private static UserController userController;
    private static OperationController operationController;
    private static WageController wageController;
    private static SessionController sessionController;
    private static ContractController contractController;

    private static boolean running = true;

    public static void main(String[] args) {
        initServices();
        initControllers();
        initObservers();

        DataLoader dataLoader = new DataLoader();
        dataLoader.init();

        mainLoop();
    }

    private static void initObservers() {
        EmployeeObserver employeeObserver = new EmployeeObserver();
    }

    private static void mainLoop() {
        while(running){
            mainController.mainMenu();
        }
    }

    private static void initServices() {
        operationService = new OperationServiceMap();
        employeeService = new EmployeeServiceMap(operationService);
        userService = new UserServiceMap();
        sessionService = new SessionServiceImpl();
    }

    private static void initControllers() {
        employeeController = new EmployeeController();
        userController = new UserController();
        operationController = new OperationController();
        wageController = new WageController();
        sessionController = new SessionController();
        mainController = new MainController();
        contractController = new ContractController();
    }

    public static void exit() {
        running = false;
    }

    public static OperationService getOperationService() {
        return operationService;
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static SessionService getSessionService() {
        return sessionService;
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static EmployeeController getEmployeeController() {
        return employeeController;
    }

    public static UserController getUserController() {
        return userController;
    }

    public static OperationController getOperationController() {
        return operationController;
    }

    public static WageController getWageController() {
        return wageController;
    }

    public static SessionController getSessionController() {
        return sessionController;
    }

    public static ContractController getContractController() { return contractController; }
}
