package com.tds.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/tds/employee")
@RestController
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get-all-employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get-employee-by-id")
    public Employee getEmployeeById(@RequestParam("employeeId") String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/get-employee-by-name")
    public List<Employee> getEmployeeByName(@RequestParam("employeeName") String employeeName) {
        return employeeService.getEmployeeByName(employeeName);
    }

    @DeleteMapping("/delete-employee-by-id")
    public String deleteEmployeeById(@RequestParam("employeeId") String employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee deleted successfully";
    }

    @PostMapping("/create-employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
