package com.alexb.empconsumer.repository;

import com.alexb.empconsumer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
