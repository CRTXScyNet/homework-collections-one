package com.example.homework.homeworkcollectionsone;

import java.util.ArrayList;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map getEmployeeList();
}
