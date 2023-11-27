package io.employees.HomeWork;

public interface EmployeeService {
    boolean addNewEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;
    boolean removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;
    boolean findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;
}
