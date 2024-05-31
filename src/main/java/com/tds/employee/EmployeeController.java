package com.tds.employee;

import com.tds.response.ResponseObject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseObject<List<Employee>> getAllEmployees() {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", employeeService.getAllEmployees());
    }

    @GetMapping("/get-employee-by-id")
    public ResponseObject<Employee> getEmployeeById(@RequestParam("employeeId") String employeeId) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", employeeService.getEmployeeById(employeeId));
    }

    @GetMapping("/get-employee-by-name")
    public ResponseObject<List<Employee>> getEmployeeByName(@RequestParam("employeeName") String employeeName) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", employeeService.getEmployeeByName(employeeName));
    }

    @DeleteMapping("/delete-employee-by-id")
    public ResponseObject<String> deleteEmployeeById(@RequestParam("employeeId") String employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Employee deleted successfully", employeeId);
    }

    @PostMapping("/create-employee")
    public ResponseObject<Employee> createEmployee(@RequestBody @Valid Employee employee) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", employeeService.createEmployee(employee));
    }
}
