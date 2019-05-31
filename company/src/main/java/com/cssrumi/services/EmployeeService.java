package com.cssrumi.services;

import com.cssrumi.listener.Listener;
import com.cssrumi.model.Employee;
import com.cssrumi.services.map.NameConsumer;

import java.util.Set;

public interface EmployeeService extends CrudService<Employee, Long>, NameConsumer {

    Employee findByLastName(String lastName);

    Set<Employee> findAllByLastName(String lastName);

    Set<Employee> findAllByFullName(String fullName);

    Employee createAndSave(String fullName);

    Employee createAndSave(String firstName, String lastName);

    Listener getListener();
}
