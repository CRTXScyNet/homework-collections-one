package com.example.homework.homeworkcollectionsone.departments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "{id:\\d+}/min")
    public int getMinSalaryEmployee(@PathVariable int id) {
        return departmentService.getMinSalaryEmployee(id);
    }

    @GetMapping(path = "{id:\\d+}/max")
    public int getMaxSalaryEmployee(@PathVariable int id) {
        return departmentService.getMaxSalaryEmployee(id);
    }

    @GetMapping(path = "{id:\\d+}/sum")
    public int getSumSalaryEmployee(@PathVariable int id) {
        return departmentService.getSumSalaryEmployee(id);
    }

    @GetMapping(path = "{id:\\d+}/employees")
    public Object getDepartmentEmployees(@PathVariable int id) {
        return departmentService.getDepartmentEmployees(id);
    }

    @GetMapping(path = "/employees")
    public Object getEmployeesGroupedByDepartment() {
        return departmentService.getEmployeesGroupedByDepartment();
    }
}
