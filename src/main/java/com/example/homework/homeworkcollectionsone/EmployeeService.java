package com.example.homework.homeworkcollectionsone;

import com.example.homework.homeworkcollectionsone.exceptions.AbsentVariableException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeAlreadyAddedException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeNotFoundException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private ArrayList<Employee> employees;
    private final int maxEmployeeAmount;

    public EmployeeService() {
        this.employees = new ArrayList<>();
        this.maxEmployeeAmount = 15;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw new AbsentVariableException();
        }
        boolean employeeAlreadyExist = employees.stream().anyMatch(e -> e.getFirstName().equalsIgnoreCase(firstName)
                && e.getLastName().equalsIgnoreCase(lastName));
        if (employeeAlreadyExist) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= maxEmployeeAmount) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw new AbsentVariableException();
        }
        boolean employeeExist = employees.stream().anyMatch(e -> e.getFirstName().equalsIgnoreCase(firstName)
                && e.getLastName().equalsIgnoreCase(lastName));
        if (!employeeExist) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employees.stream().filter(e -> e.getFirstName().equalsIgnoreCase(firstName)
                && e.getLastName().equalsIgnoreCase(lastName)).toList().get(0);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw new AbsentVariableException();
        }
        boolean employeeExist = employees.stream().anyMatch(e -> e.getFirstName().equalsIgnoreCase(firstName)
                && e.getLastName().equalsIgnoreCase(lastName));
        if (!employeeExist) {
            throw new EmployeeNotFoundException();
        }
        return employees.stream().filter(e -> e.getFirstName().equalsIgnoreCase(firstName)
                && e.getLastName().equalsIgnoreCase(lastName)).toList().get(0);
    }

    @Override
    public ArrayList<Employee> getEmployeeList() {
        return employees;
    }


}
