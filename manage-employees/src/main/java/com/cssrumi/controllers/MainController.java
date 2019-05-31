package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.services.SessionService;
import com.cssrumi.view.MainView;

public class MainController {

    private SessionService sessionService;

    public MainController() {
        sessionService = App.getSessionService();
    }

    public MainController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void mainMenu() {
        String choice = MainView.mainMenu(sessionService.isAuthorized());
        switch (choice.toLowerCase()) {
            case "e":
                App.getEmployeeController().menu();
                break;
            case "w":
                App.getWageController().menu();
                break;
            case "c":
                App.getContractController().menu();
                break;
            case "o":
                App.getOperationController().menu();
                break;
            case "u":
                App.getUserController().menu();
                break;
            case "l":
                if(sessionService.isAuthorized())
                    sessionService.logout();
                else
                    App.getSessionController().authorize();
                break;
            case "x":
                App.exit();
            default:
                break;
        }
    }
}
