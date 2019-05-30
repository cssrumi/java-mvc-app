package com.cssrumi.services;

import com.cssrumi.model.Contract;
import com.cssrumi.model.Wage;
import io.reactivex.Observable;

public interface EmployeeObservable {

    Observable<Wage> getWageObservable();

    Observable<Contract> getContractObservable();

}
