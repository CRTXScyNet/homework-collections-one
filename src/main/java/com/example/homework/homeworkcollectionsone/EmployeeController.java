package com.example.homework.homeworkcollectionsone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    String greetings() {
        return "Добро пожаловать в нашу компанию";
    }

    @GetMapping(path = "/add")
    Employee addEmployee(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    Employee deleteEmployee(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    Employee findEmployee(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/all")
    Map getEmployeeList() {
        return employeeService.getEmployeeList();
    }
}
