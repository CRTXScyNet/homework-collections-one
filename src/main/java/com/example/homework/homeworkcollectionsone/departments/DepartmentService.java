package com.example.homework.homeworkcollectionsone.departments;

import com.example.homework.homeworkcollectionsone.employees.Employee;

import java.util.Collection;

public interface DepartmentService {
    int getMinSalaryEmployee(int departmentNumber);

    int getMaxSalaryEmployee(int departmentNumber);
    int getSumSalaryEmployee(int departmentNumber);

    Object getDepartmentEmployees(Integer departmentNumber);
    Object getEmployeesGroupedByDepartment();

}
