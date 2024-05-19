package com.example.homework.homeworkcollectionsone.departments;

import com.example.homework.homeworkcollectionsone.employees.Employee;
import com.example.homework.homeworkcollectionsone.employees.EmployeeServiceImpl;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMinSalaryEmployee(int departmentNumber) {
        return employeeService.getEmployeeList().values().stream()
                .filter(e -> e.getDepartment() == departmentNumber)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getMaxSalaryEmployee(int departmentNumber) {
        return employeeService.getEmployeeList().values().stream()
                .filter(e -> e.getDepartment() == departmentNumber)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Object getDepartmentEmployees(Integer departmentNumber) {
        List<Employee> employees = employeeService.getEmployeeList()
                .values().stream().
                toList();
        if (departmentNumber == null) {
            return employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
        } else {
            return employees.stream()
                    .filter(e -> e.getDepartment() == departmentNumber)
                    .toList();
        }
    }
}
