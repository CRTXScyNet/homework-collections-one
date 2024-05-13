package com.example.homework.homeworkcollectionsone;

import java.util.ArrayList;

public interface EmployeeServiceInterface {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    ArrayList<Employee> getEmployeeList();
}
