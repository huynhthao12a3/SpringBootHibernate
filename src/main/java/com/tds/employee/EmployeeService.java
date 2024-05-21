package com.tds.employee;

import com.tds.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getEmployeeByName(String employeeName) {
        return employeeRepository.findEmployeeListByName(employeeName);
    }

    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
