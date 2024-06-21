package com.example.homework.homeworkcollectionsone.employees;

import com.example.homework.homeworkcollectionsone.exceptions.AbsentVariableException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeAlreadyAddedException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeNotFoundException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeStorageIsFullException;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees;

    Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();

    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        firstName = checkInput(firstName);
        lastName = checkInput(lastName);
        Employee employee = new Employee(firstName, lastName);

        employeeExist(employee.getFullName(), false);

        if (employees.size() >= Employee.maxEmployeeAmount) {
            throw new EmployeeStorageIsFullException();
        }

        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        firstName = checkInput(firstName);
        lastName = checkInput(lastName);
        String fullName = firstName + " " + lastName;
        employeeExist(firstName + " " + lastName, true);
        Employee employee = employees.get(fullName);
        employees.remove(fullName);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        firstName = checkInput(firstName);
        lastName = checkInput(lastName);
        String fullName = firstName + " " + lastName;
        employeeExist(firstName + " " + lastName, true);
        return employees.get(fullName);
    }

    @Override
    public Map<String, Employee> getEmployeeList() {
        return employees;
    }

    @Override
    public void employeeExist(String fullName, boolean shouldExist) {
        boolean employeeExist = employees.containsKey(fullName);
        if (employeeExist && !shouldExist) {
            throw new EmployeeAlreadyAddedException();
        }
        if (!employeeExist && shouldExist) {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public String checkInput(String s) {
        String newS = StringUtils.trim(s);
        if (s == null || s.isBlank()) {
            throw new AbsentVariableException();
        }
        if (!StringUtils.isAlpha(newS)) {
            throw new AbsentVariableException();

        }
        newS = StringUtils.capitalize(newS.toLowerCase());
        return newS;
    }

    @Value("${soska}")
    private String string;

    @PostConstruct
    public void init() {
//        employees.put("Aleksandr Sorokin", new Employee("Aleksandr","Sorokin",1,500));
//        employees.put("Misha Skoroped", new Employee("Misha","Skoroped",2,16000));
//        employees.put("Andrey Podlecov", new Employee("Andrey","Podlecov",3,10000));
//        employees.put("Viola Viagra", new Employee("Viola","Viagra",4,100000));

//        for (int i = 0; i < Employee.maxEmployeeAmount-1; i++) {
//            Employee employee = Employee.createEmployee();
//            employees.put(employee.getFullName(), employee);
//        }
        log.info(string);
    }
}
