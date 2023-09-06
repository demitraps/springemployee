package com.hellodemitra.springbootemployee.repository;

import com.hellodemitra.springbootemployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
