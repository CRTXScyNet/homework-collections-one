package com.example.homework.homeworkcollectionsone.departments;

import com.example.homework.homeworkcollectionsone.employees.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(path = "/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam("departmentId") int departmentNumber) {
        return departmentService.getMinSalaryEmployee(departmentNumber);
    }

    @RequestMapping(path = "/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam("departmentId") int departmentNumber) {
        return departmentService.getMaxSalaryEmployee(departmentNumber);
    }

    @RequestMapping(path = "/all")
    public Object getDepartmentEmployees(@RequestParam(value = "departmentId", required = false) Integer departmentNumber) {
        return departmentService.getDepartmentEmployees(departmentNumber);
    }
}
