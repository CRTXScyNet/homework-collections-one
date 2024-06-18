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
    public int getMinSalaryEmployee(int id) {
        return employeeService.getEmployeeList().values().stream()
                .filter(e -> e.getDepartment() == id)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new).getSalary();
    }

    @Override
    public int getMaxSalaryEmployee(int id) {
        return employeeService.getEmployeeList().values().stream()
                .filter(e -> e.getDepartment() == id)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new).getSalary();
    }

    public int getSumSalaryEmployee(int id) {
        return employeeService.getEmployeeList().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(Employee::getSalary).sum();
    }

    @Override
    public Object getDepartmentEmployees(int id) {
        List<Employee> employees = employeeService.getEmployeeList()
                .values().stream().
                toList();
        return employees.stream()
                .filter(e -> e.getDepartment() == id)
                .toList();

    }

    @Override
    public Object getEmployeesGroupedByDepartment() {
        List<Employee> employees = employeeService.getEmployeeList()
                .values().stream().
                toList();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));

    }
}
