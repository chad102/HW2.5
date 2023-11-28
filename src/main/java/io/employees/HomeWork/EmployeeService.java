package io.employees.HomeWork;

import java.util.List;

public interface EmployeeService {
    Employee addNewEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> printAllEmployees();
}