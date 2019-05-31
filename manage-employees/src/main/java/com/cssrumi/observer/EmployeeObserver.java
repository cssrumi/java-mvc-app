package com.cssrumi.observer;

import com.cssrumi.App;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.view.EmployeeView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EmployeeObserver implements PropertyChangeListener {

    private EmployeeService employeeService;
    private Calendar cal = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public EmployeeObserver() {
        App.getEmployeeService().getListener().addChangeListener(this);
    }

    public EmployeeObserver(EmployeeService employeeService) {
        this.employeeService = employeeService;
        employeeService.getListener().addChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        EmployeeView.log(sdf.format(cal.getTime()) + " Changed property: " + event.getPropertyName() + " [old -> "
                + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
    }
}
