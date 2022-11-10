package com.prestagestion.gestionapi.employees.impl;

import com.prestagestion.gestionapi.employees.EmployeeEntity;
import com.prestagestion.gestionapi.employees.EmployeeRepository;
import com.prestagestion.gestionapi.employees.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Data
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private   final EmployeeRepository employeeRepository;

    @Override
    public Optional<EmployeeEntity> getEmployeeById(Long employeeId) {

            if (employeeId == null ){
                return null;
            }
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void  saveEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return null;
    }

    @Override
    public void delete(long employeeid) {

    }
}
