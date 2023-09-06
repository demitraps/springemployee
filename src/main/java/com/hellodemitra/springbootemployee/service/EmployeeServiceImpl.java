package com.hellodemitra.springbootemployee.service;

import com.hellodemitra.springbootemployee.model.Employee;
import com.hellodemitra.springbootemployee.repository.EmployeeRepository;
import com.hellodemitra.springbootemployee.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//
//        try {
//            if(employee.isEmpty()) {
//                throw new ResourceNotFoundException(id);
//            }
//
//        } catch (ResourceNotFoundException e) {
//            e.printStackTrace();
//        }
//        return employee.get();

        try {
            return employeeRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException(id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        // check if employee with given id exists in DB
        try {
            Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(id));

            existingEmployee.setFirstname(employee.getFirstname());
            existingEmployee.setLastname(employee.getLastname());
            existingEmployee.setEmail(employee.getEmail());

            //save existingEmployee to DB
            employeeRepository.save(existingEmployee);
            return existingEmployee;

        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
