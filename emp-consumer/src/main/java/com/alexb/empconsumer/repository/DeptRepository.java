package com.alexb.empconsumer.repository;

import com.alexb.empconsumer.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Department, Integer> {
}