package com.example.homework.homeworkcollectionsone.employees;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int departmentId, int salar);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map getEmployeeList();

    void employeeExist(String fullName, boolean shouldExist);

    String checkInput(String s);
}
