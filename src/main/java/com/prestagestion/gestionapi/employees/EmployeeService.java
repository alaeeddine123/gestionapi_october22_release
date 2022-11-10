package com.prestagestion.gestionapi.employees;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
public interface EmployeeService {

    Optional <EmployeeEntity> getEmployeeById(Long employeeId);
    void  saveEmployee(EmployeeEntity employeeEntity);
    List<EmployeeEntity> findAll();
    void delete(long employeeid);


}
