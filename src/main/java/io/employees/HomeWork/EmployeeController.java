package io.employees.HomeWork;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/add")
    public Employee add (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        try {
            return employeeServiceImpl.addNewEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException exception1) {
            System.out.println(exception1.getMessage());
        }
        return employeeServiceImpl.addNewEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee remove (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        try {
            return employeeServiceImpl.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException exception2) {
            System.out.println(exception2.getMessage());
        }
        return employeeServiceImpl.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        try {
            return employeeServiceImpl.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException exception2) {
            System.out.println(exception2.getMessage());
        }
        return employeeServiceImpl.findEmployee(firstName, lastName);
    }
    @GetMapping
    public List<Employee> printList() {
        return  employeeServiceImpl.printAllEmployees();
    }

}
