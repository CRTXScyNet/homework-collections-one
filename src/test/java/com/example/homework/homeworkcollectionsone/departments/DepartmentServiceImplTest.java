package com.example.homework.homeworkcollectionsone.departments;

import com.example.homework.homeworkcollectionsone.employees.Employee;
import com.example.homework.homeworkcollectionsone.employees.EmployeeServiceImpl;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeNotFoundException;
import com.example.homework.homeworkcollectionsone.exceptions.WrongDepartmentIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    private final EmployeeServiceImpl employeeService = mock(EmployeeServiceImpl.class);
    private final Employee employee = new Employee("Aleksandr", "Sorokin", 1, 500);
    private final Employee employee2 = new Employee("Misha", "Skoroped", 1, 16000);
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void initDepartmentService() {
        departmentService = new DepartmentServiceImpl(employeeService);
    }

    @Test
    void getMinSalaryEmployee() {
        //given
        assertNotNull(employeeService);

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(employee.getFullName(), employee);
        employeeMap.put(employee2.getFullName(), employee2);

        when(employeeService.getEmployeeList()).thenReturn(employeeMap);
        //do
        //then
        assertEquals(
                employee.getSalary(),
                departmentService.getMinSalaryEmployee(employee.getDepartment())
        );
    }

    @Test
    void getMinSalaryEmployeeThatDoesNotExistShouldThrowException() {
        //given
        assertNotNull(employeeService);

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(employee.getFullName(), employee);
        employeeMap.put(employee2.getFullName(), employee2);

        when(employeeService.getEmployeeList()).thenReturn(employeeMap);
        //do
        //then
        assertThrows(
                EmployeeNotFoundException.class,
                () -> departmentService.getMinSalaryEmployee(2)
        );
    }

    @Test
    void getMinSalaryEmployeeWithWrongDivisionIdShouldThrowException() {
        //given
        assertNotNull(employeeService);

        Map<String, Employee> employeeMap = new HashMap<>();

        when(employeeService.getEmployeeList()).thenReturn(employeeMap);
        //do
        //then
        assertThrows(
                WrongDepartmentIdException.class,
                () -> departmentService.getMinSalaryEmployee(0)
        );
    }

    @Test
    void getMaxSalaryEmployee() {
        //given
        assertNotNull(employeeService);

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(employee.getFullName(), employee);
        employeeMap.put(employee2.getFullName(), employee2);

        when(employeeService.getEmployeeList()).thenReturn(employeeMap);
        //do
        //then
        assertEquals(
                employee2.getSalary(),
                departmentService.getMaxSalaryEmployee(1)
        );
    }

    @Test
    void getMaxSalaryEmployeeThatDoesNotExistShouldThrowException() {
        //given
        assertNotNull(employeeService);

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(employee.getFullName(), employee);
        employeeMap.put(employee2.getFullName(), employee2);

        when(employeeService.getEmployeeList()).thenReturn(employeeMap);
        //do
        //then
        assertThrows(
                EmployeeNotFoundException.class,
                () -> departmentService.getMaxSalaryEmployee(2)
        );
    }

    @Test
    void getMaxSalaryEmployeeWithWrongDivisionIdShouldThrowException() {
        //given
        assertNotNull(employeeService);

        //do
        //then
        assertThrows(
                WrongDepartmentIdException.class,
                () -> departmentService.getMaxSalaryEmployee(0)
        );
    }

    @Test
    void getSumSalaryEmployee() {
        //given
        assertNotNull(employeeService);

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(employee.getFullName(), employee);
        employeeMap.put(employee2.getFullName(), employee2);

        when(employeeService.getEmployeeList()).thenReturn(employeeMap);
        //do
        //then
        assertEquals(
                employee.getSalary() + employee2.getSalary(),
                departmentService.getSumSalaryEmployee(1)
        );
    }

    @Test
    void getSumSalaryEmployeeWithWrongDivisionIdShouldThrowException() {
        //given
        assertNotNull(employeeService);

        //do
        //then
        assertThrows(
                WrongDepartmentIdException.class,
                () -> departmentService.getSumSalaryEmployee(0)
        );
    }

    @Test
    void getDepartmentEmployees() {
        //given
        assertNotNull(employeeService);

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(employee.getFullName(), employee);
        employeeMap.put(employee2.getFullName(), employee2);

        when(employeeService.getEmployeeList()).thenReturn(employeeMap);
        //do
        //then
        assertEquals(
                employeeMap.values()
                        .stream()
                        .toList(),
                departmentService.getDepartmentEmployees(1)
        );
    }

    @Test
    void getDepartmentEmployeesWithWrongDivisionIdShouldThrowException() {
        //given
        assertNotNull(employeeService);

        //do
        //then
        assertThrows(
                WrongDepartmentIdException.class,
                () -> departmentService.getDepartmentEmployees(0)
        );
    }

    @Test
    void getEmployeesGroupedByDepartment() {
        //given
        assertNotNull(employeeService);

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(employee.getFullName(), employee);
        employeeMap.put(employee2.getFullName(), employee2);

        when(employeeService.getEmployeeList()).thenReturn(employeeMap);
        //do
        //then
        assertEquals(
                employeeMap.values()
                        .stream()
                        .collect(
                                Collectors.groupingBy(Employee::getDepartment, Collectors.toList())
                        ),
                departmentService.getEmployeesGroupedByDepartment()
        );
    }
}