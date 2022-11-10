package com.prestagestion.gestionapi.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long > {




}
