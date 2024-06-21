package com.example.homework.homeworkcollectionsone.departments;

import com.example.homework.homeworkcollectionsone.employees.Employee;

import java.util.Collection;

public interface DepartmentService {
    int getMinSalaryEmployee(int id);

    int getMaxSalaryEmployee(int id);
    int getSumSalaryEmployee(int id);

    Object getDepartmentEmployees(int id);
    Object getEmployeesGroupedByDepartment();

}
