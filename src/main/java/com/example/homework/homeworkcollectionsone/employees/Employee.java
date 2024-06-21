package com.example.homework.homeworkcollectionsone.employees;

import java.util.Objects;

public class Employee {


    private String firstName;
    private String lastName;
    private String fullName;
    private int department;
    private int salary;

    static final int maxEmployeeAmount = 10;


    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        fullName = firstName + " " + lastName;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        fullName = firstName + " " + lastName;
        department = 0;
        salary = 15000;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" + "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    static Employee createEmployee() {
        String firstName = createRandomString();
        String lastName = createRandomString();
        int division = (int) (Math.random() * 4) + 1;
        int salary = (int) (Math.random() * 50000);
        return new Employee(firstName, lastName, division, salary);
    }

    static String createRandomString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(getRandomLetter(true));
        int length = (int) (Math.random() * 10);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(getRandomLetter(false));
        }
        return stringBuffer.toString();
    }

    static char getRandomLetter(boolean isUpperCase) {
        int i = (int) (64 + Math.random() * (122 - 64));
        char r = (char) i;
        if (isUpperCase) {
            if (Character.isLetter(r) && Character.isUpperCase(r)) {
                return r;
            } else {
                return getRandomLetter(isUpperCase);
            }
        } else {
            if (Character.isLetter(r) && Character.isLowerCase(r)) {
                return r;
            } else {
                return getRandomLetter(isUpperCase);
            }
        }
    }
}
