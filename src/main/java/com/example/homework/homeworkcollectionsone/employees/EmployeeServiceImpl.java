package com.example.homework.homeworkcollectionsone.employees;

import com.example.homework.homeworkcollectionsone.exceptions.AbsentVariableException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeAlreadyAddedException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeNotFoundException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees;
    private final int maxEmployeeAmount;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        this.maxEmployeeAmount = 15;
        for (int i = 0; i < maxEmployeeAmount; i++) {
            Employee employee = Employee.createEmployee();
            employees.put(employee.getFullName(),employee);
        }
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw new AbsentVariableException();
        }

        Employee employee = new Employee(firstName, lastName);
        boolean employeeAlreadyExist = employees.containsKey(employee.getFullName());
        if (employeeAlreadyExist) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= maxEmployeeAmount) {
            throw new EmployeeStorageIsFullException();
        }

        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw new AbsentVariableException();
        }
        String fullName = firstName + " " + lastName;
        boolean employeeExist = employees.containsKey(firstName + " " + lastName);
        if (!employeeExist) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employees.get(fullName);
        employees.remove(fullName);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw new AbsentVariableException();
        }
        String fullName = firstName + " " + lastName;
        Employee employeeExist = employees.get(fullName);
        if (employeeExist == null) {
            throw new EmployeeNotFoundException();
        }
        return employeeExist;
    }

    @Override
    public Map<String,Employee> getEmployeeList() {
        return employees;
    }


}
