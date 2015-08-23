package com.company.brokers;

public class WorksFor {

    private double salary;
    private Company company;

    public WorksFor(double salary, Company company) {
        this.salary = salary;
        this.company = company;
    }

    public double getSalary() {
        return this.salary;
    }

    public Company company() {
        return this.company;
    }

}
