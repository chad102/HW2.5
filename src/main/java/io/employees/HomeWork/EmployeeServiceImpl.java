package io.employees.HomeWork;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private static final int MAX_SIZE = 100;

    public Employee addNewEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employees.contains(e)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен в список");
        }
        if (employees.size() <= MAX_SIZE) {
            employees.add(e);
            return e;
        } else {
            throw new EmployeeStorageIsFullException("Превышено максимальное количество сотрудников");
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employees.contains(e)) {
            employees.remove(e);
            return e;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employees.contains(e)){
            return e;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public List<Employee> printAllEmployees() {
            return employees;
    }
}
