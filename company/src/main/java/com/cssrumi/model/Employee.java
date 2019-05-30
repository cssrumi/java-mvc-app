package com.cssrumi.model;

import io.reactivex.subjects.BehaviorSubject;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class Employee extends Person implements Hired, Comparable<Employee>{

    private Wage wage;
    private Contract contract;
    private static float holidayBonus = 1000f;
    private Set<Operation> operations = new HashSet<>();

    private final BehaviorSubject<Wage> wageObservable = BehaviorSubject.create();
    private final BehaviorSubject<Contract> contactObservable = BehaviorSubject.create();

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void setWage(Wage wage) {
        wageObservable.onNext(this.wage);
        this.wage = wage;
        wageObservable.onNext(wage);
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
        if(isGreater)
            return 1;
        if(getWage().basic == o.getWage().basic)
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
        if(wage != null)
            return (double) wage.basic;
        return 0.0;
    }

    public float add(float f) {
        if(wage != null)
            return wage.basic + f;
        return f;
    }

    public double add(double d) {
        if(wage != null)
            return wage.basic + d;
        return d;
    }

    public int add(int i) {
        if(wage != null)
            return (int) wage.basic + i;
        return i;
    }

    public long add(long l) {
        if(wage != null)
            return (long) wage.basic + l;
        return l;
    }
}
