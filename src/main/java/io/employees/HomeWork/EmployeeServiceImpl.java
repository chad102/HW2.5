package io.employees.HomeWork;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
@Service
public class EmployeeServiceImpl extends Employee implements EmployeeService {
    Employee e = new Employee(getFirstName(),getLastName());
    private final List<Employee> employees = new ArrayList<>(200);

    public EmployeeServiceImpl(String firstName, String lastName) {
        super(firstName, lastName);
    }
    @Bean
    public boolean addNewEmployee(String firstName, String lastName) {
        if (employees.equals(e)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен в список");
        }
        if (employees.size() <= 200) {
            return employees.add(e);
        } else {
            throw new EmployeeStorageIsFullException("Превышено максимальное количество сотрудников");
        }
    }
    @Bean
    public boolean removeEmployee(String firstName, String lastName) {
        if (employees.contains(e)) {
            return employees.remove(e);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }
    @Bean
    public boolean findEmployee(String firstName, String lastName) {
        if (employees.contains(e)){
            return true;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

    }
}
