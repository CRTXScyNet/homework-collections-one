package com.example.homework.homeworkcollectionsone.employees;

import com.example.homework.homeworkcollectionsone.exceptions.AbsentVariableException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeAlreadyAddedException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeNotFoundException;
import com.example.homework.homeworkcollectionsone.exceptions.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceImplTest {
    //addEmployee
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private final Employee employee = new Employee("Aleksandr", "Sorokin", 1, 500);

    @Test
    public void addEmployee() {
        //given
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(employee.getFullName(), employee);

        //do
        employeeService.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getSalary()
        );

        //then
        assertEquals(employeeMap, employeeService.getEmployeeList());
    }

    @Test
    public void whenAddExistedEmployeeShouldThrowException() {
        //given
        employeeService.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getSalary()
        );

        //do
        //then
        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeService.addEmployee(
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment(),
                    employee.getSalary()
            );
        });

    }

    @Test
    public void whenAddEmployeeToFullStorageShouldThrowException() {
        //given

        for (int i = 0; i < Employee.maxEmployeeAmount; i++) {
            Employee employee1 = Employee.createEmployee();
            employeeService.addEmployee(
                    employee1.getFirstName(),
                    employee1.getLastName(),
                    employee1.getDepartment(),
                    employee1.getSalary()
            );
        }
        //do
        //then
        assertThrows(EmployeeStorageIsFullException.class, () -> {
            employeeService.addEmployee("Sok", "Prn", 4, 50000);
        });
    }

    //deleteEmployee

    @Test
    public void deleteEmployee() {
        //given
        Map<String, Employee> employeeMap = new HashMap<>();

        //do
        employeeService.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getSalary()
        );
        employeeService.deleteEmployee(employee.getFirstName(), employee.getLastName());

        //then
        assertEquals(employeeMap, employeeService.getEmployeeList());
    }

    @Test
    public void whenDeleteNotExistedEmployeeShouldThrowException() {
        //given
        //do
        //then
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.deleteEmployee(employee.getFirstName(), employee.getLastName());
        });
    }

    //findEmployee
    @Test
    public void findEmployee() {
        //given
        employeeService.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getSalary()
        );

        //do
        //then
        assertEquals(employee, employeeService.findEmployee(employee.getFirstName(), employee.getLastName()));
    }

    @Test
    public void whenTryToFindNotExistedEmployeeShouldThrowException() {
        //given
        //do
        //then
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.findEmployee(employee.getFirstName(), employee.getLastName());
        });
    }

    //getEmployeeList
    @Test
    public void getEmployeeList() {
        //given

        //do
        //then
        assertEquals(HashMap.class, employeeService.employees.getClass());
    }

    //employeeExist
    @Test
    public void employeeExist() {
        //given

        //do

        //then


    }

    //checkInput
    @ParameterizedTest
    @MethodSource(value = "checkInputThrowsExceptionSource")
    public void checkInputThrowsException(String s) {
        //given
        //do
        //then
        assertThrows(AbsentVariableException.class, () -> employeeService.checkInput(s));
    }

    public static Stream<Arguments> checkInputThrowsExceptionSource() {
        return Stream.of(
                Arguments.of("al ex"),
                Arguments.of("1lex"),
                Arguments.of(""),
                Arguments.of("A?ex")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "checkInputSource")
    public void checkInput(String actual, String expected) {
        //given
        //do
        //then
        assertEquals(expected, employeeService.checkInput(actual));
    }

    public static Stream<Arguments> checkInputSource() {
        return Stream.of(
                Arguments.of("alex", "Alex"),
                Arguments.of("aLex", "Alex"),
                Arguments.of("Alex", "Alex")

        );
    }

}