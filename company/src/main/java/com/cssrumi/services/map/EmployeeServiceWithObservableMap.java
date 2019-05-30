package com.cssrumi.services.map;

import com.cssrumi.model.Contract;
import com.cssrumi.model.Employee;
import com.cssrumi.model.Wage;
import com.cssrumi.services.EmployeeObservable;
import com.cssrumi.services.OperationService;
import io.reactivex.Observable;

public class EmployeeServiceWithObservableMap extends EmployeeServiceMap implements EmployeeObservable {

    Observable<Wage> wageObservable;
    Observable<Contract> contractObservable;


    public EmployeeServiceWithObservableMap(OperationService operationService) {
        super(operationService);
    }

    @Override
    public Employee save(Employee object) {
        Employee employee = super.save(object);
        if (employee != null) {
            if (wageObservable != null)
                wageObservable = Observable.merge(wageObservable, object.getWageSubject());
            else
                wageObservable = object.getWageSubject();
            if (contractObservable != null)
                contractObservable = Observable.merge(contractObservable, object.getContactSubject());
            else
                contractObservable = object.getContactSubject();
        }
        return employee;
    }

    @Override
    public Observable<Wage> getWageObservable() {
        return null;
    }

    @Override
    public Observable<Contract> getContractObservable() {
        return null;
    }
}
