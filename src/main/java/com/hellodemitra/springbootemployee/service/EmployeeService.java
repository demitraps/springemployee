package com.hellodemitra.springbootemployee.service;

import com.hellodemitra.springbootemployee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
}
