package com.company.brokers;

public class Person {

    private String name;
    private WorksFor worksFor;

    public Person(String name, WorksFor worksFor) {
        this.name = name;
        this.worksFor = worksFor;
    }

    public String getName() {
        return this.name;
    }

    public WorksFor worksFor() {
        return this.worksFor;
    }

}
