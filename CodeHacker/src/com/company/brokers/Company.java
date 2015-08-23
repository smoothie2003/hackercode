package com.company.brokers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varun on 6/15/2015.
 */
public class Company {
    private String name;
    private List<Person> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<Person>();
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void addEmployee(Person employee) {
        this.employees.add(employee);
    }

    public String getName() {
        return this.name;
    }



}
