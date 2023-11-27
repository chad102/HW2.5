package io.employees.HomeWork;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/add")
    public boolean add (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        return employeeServiceImpl.addNewEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public boolean remove (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        return employeeServiceImpl.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public boolean find (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        return employeeServiceImpl.findEmployee(firstName, lastName);
    }

}
