package com.company.brokers;

public class PrintEmployeeAndSalary {

    public static void main(String[] args) {
        Company company = new Company("IBC");
        Person person = new Person("James", new WorksFor(100000, company));
        company.addEmployee(person);
        printAllEmployeesAndSalaries(company);
    }

    private static void printAllEmployeesAndSalaries(Company company) {
        StringBuffer printer = new StringBuffer();

        printer.append("For the Company : ").append(company.getName()).append(" These are the employees and Salaries :").append("\n");
        
        for(Person person : company.getEmployees()) {
            printer.append(person.getName()).append("\t").append(person.worksFor().getSalary()).append("\n");
        }

        System.out.println(printer.toString());
    }
}
