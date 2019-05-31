package com.cssrumi.model;

import com.cssrumi.listener.Listener;
import com.cssrumi.services.map.NameConsumer;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Setter
@Getter
public class Employee extends Person implements Hired, Comparable<Employee>, NameConsumer {

    private Wage wage;
    private Contract contract;
    private static float holidayBonus = 1000f;
    private Set<Operation> operations = new HashSet<>();
    private Listener listener;
    private Consumer<String> nameConsumer;

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
        if (nameConsumer != null)
            nameConsumer.accept(firstName);
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
        if (nameConsumer != null)
            nameConsumer.accept(lastName);
    }

    public void setWage(Wage wage) {
        if (listener != null)
            listener.notifyListeners(
                    this,
                    Wage.class.toString(),
                    this.wage,
                    this.wage = wage
            );
        else
            this.wage = wage;
    }

    public void setContract(Contract contract) {
        if (listener != null)
            listener.notifyListeners(
                    this,
                    Contract.class.toString(),
                    this.contract,
                    this.contract = contract
            );
        else
            this.contract = contract;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Employee))
            return false;
        return obj.toString()
                .equals(this.toString());
    }

    @Override
    public int compareTo(Employee o) {
        if ((getWage() == null) || (o.getWage() == null))
            throw new IllegalArgumentException("Wage can't be unset");
        boolean isGreater = getWage().basic > o.getWage().basic;
        if (isGreater)
            return 1;
        if (getWage().basic == o.getWage().basic)
            return 0;
        else return -1;
    }

    public boolean isGreaterThan(Employee e) {
        return compareTo(e) > 0;
    }

    public boolean isLessThan(Employee e) {
        return compareTo(e) < 0;
    }

    public boolean isGreaterOrEqual(Employee e) {
        return compareTo(e) >= 0;
    }

    public boolean isLessOrEqual(Employee e) {
        return compareTo(e) <= 0;
    }

    public double toDouble() {
        if (wage != null)
            return (double) wage.basic;
        return 0.0;
    }

    public float add(Employee employee) {
        if (wage == null && employee.wage == null)
            return 0f;
        else if (employee.wage != null)
            return add(employee.wage.basic);
        else return wage.basic;
    }

    public float add(float f) {
        if (wage != null)
            return wage.basic + f;
        return f;
    }

    public double add(double d) {
        if (wage != null)
            return wage.basic + d;
        return d;
    }

    public int add(int i) {
        if (wage != null)
            return (int) wage.basic + i;
        return i;
    }

    public long add(long l) {
        if (wage != null)
            return (long) wage.basic + l;
        return l;
    }
}
