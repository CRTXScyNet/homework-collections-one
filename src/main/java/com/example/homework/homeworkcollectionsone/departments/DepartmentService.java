package com.example.homework.homeworkcollectionsone.departments;

import com.example.homework.homeworkcollectionsone.employees.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee getMinSalaryEmployee(int departmentNumber);

    Employee getMaxSalaryEmployee(int departmentNumber);

    Object getDepartmentEmployees(Integer departmentNumber);

}
