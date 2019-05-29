package com.cssrumi.bootstrap;

import com.cssrumi.App;
import com.cssrumi.model.*;
import com.cssrumi.model.factories.EmployeeFactory;
import com.cssrumi.model.factories.UserFactory;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.services.UserService;

public class DataLoader {

    private final EmployeeService employeeService;
    private final UserService userService;

    public DataLoader() {
        this.employeeService = App.getEmployeeService();
        this.userService = App.getUserService();
    }

    public DataLoader(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    public void init() {
        Employee employee1 = new Employee("Adam", "Ruminski");
        Employee employee2 = EmployeeFactory.getEmployee("Krzysztof", "Nowak");
        Employee employee3 = EmployeeFactory.getEmployeeByFullName("Zdzisław Paleta");
        Employee employee4 = EmployeeFactory.getEmployeeWithContract(
                "Łoś", "Superktoś", Contract.FULLTIME
        );
        Manager manager = new Manager("Dawid", "Manager");

        employee1.setContract(Contract.FULLTIME);
        employee2.setContract(Contract.PARTTIME);
        employee3.setContract(Contract.CONTRACT);
        manager.setContract(Contract.FULLTIME);

        Wage wage1 = new Wage(1000f);
        Wage wage2 = new Wage(5000f);
        Wage wage3 = new Wage(10000f);
        Wage wage4 = new Wage(100f);
        wage4.bonus = 100;
        wage4.other = 200;
        Wage wage5 = new Wage(123f);

        employee1.setWage(wage1);
        employee2.setWage(wage2);
        employee3.setWage(wage3);
        employee4.setWage(wage4);
        manager.setWage(wage5);

        employeeService.save(employee1);
        employeeService.save(employee2);
        employeeService.save(employee3);
        employeeService.save(employee4);
        employeeService.save(manager);

        User user1 = new User("root", "root");
        User user2 = UserFactory.getUser("admin", "admin");

        userService.save(user1);
        userService.save(user2);
    }
}
