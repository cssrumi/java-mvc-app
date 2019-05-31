package com.cssrumi.services.map;

import com.cssrumi.listener.Listener;
import com.cssrumi.listener.ListenerImpl;
import com.cssrumi.model.Employee;
import com.cssrumi.model.factories.EmployeeFactory;
import com.cssrumi.services.EmployeeService;
import com.cssrumi.services.OperationService;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeServiceMap extends AbstractMapService<Employee, Long> implements EmployeeService {

    @Setter @Getter
    private Listener listener = new ListenerImpl();
    private OperationService operationService;

    public EmployeeServiceMap(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public Set<Employee> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Employee object) {
        super.delete(object);
    }

    @Override
    public Employee save(Employee object) {
        if (object != null) {
            if (object.getOperations().size() > 0) {
                object.getOperations().forEach(operation -> {
                    if (operation.getId() == null) {
                        operation.setId(operationService.save(operation).getId());
                    }
                });
            }
            if (object.getListener() == null) {
                object.setListener(listener);
            }
            return super.save(object);
        } else return null;
    }

    @Override
    public Employee findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Employee findByLastName(String lastName) {
        return map
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue().getLastName(), lastName))
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);

    }

    @Override
    public Set<Employee> findAllByLastName(String lastName) {
        return map
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue().getLastName(), lastName))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Employee> findAllByFullName(String fullName) {
        return map
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue().toString(), fullName))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    @Override
    public Employee createAndSave(String fullName) {
        return save(EmployeeFactory.getEmployeeByFullName(fullName));
    }

    @Override
    public Employee createAndSave(String firstName, String lastName) {
        return save(EmployeeFactory.getEmployee(firstName, lastName));
    }
}
