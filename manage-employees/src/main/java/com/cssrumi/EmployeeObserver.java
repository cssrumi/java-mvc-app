package com.cssrumi;

import com.cssrumi.model.Contract;
import com.cssrumi.model.Wage;
import com.cssrumi.services.EmployeeObservable;
import io.reactivex.Observer;

public class EmployeeObserver {

    EmployeeObservable employeeObservable;

    Observer<Wage> wageObserver;
    Observer<Contract> contractObserver;

    public EmployeeObserver(EmployeeObservable employeeObservable) {
        this.employeeObservable = employeeObservable;
        wageObserver = employeeObservable.getWageObservable();
    }
}
