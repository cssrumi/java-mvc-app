package com.cssrumi.observer;

import com.cssrumi.App;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EmployeeObserver implements PropertyChangeListener {


    public EmployeeObserver() {
        App.getEmployeeService().getListener().addChangeListener(this);
    }

    public EmployeeObserver(EmployeeService employeeService) {
        employeeService.getListener().addChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        Logger.log("Changed property: " + event.getPropertyName() + " [old -> "
                + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
    }
}
