package com.preparation.io;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sulfur on 24.04.16.
 */
public class Employee {

    private String name;
    private Date hireDay;

    public Employee(String name, int year, int month, int day) {
        this.name = name;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", hireDay=" + hireDay +
                '}';
    }
}
