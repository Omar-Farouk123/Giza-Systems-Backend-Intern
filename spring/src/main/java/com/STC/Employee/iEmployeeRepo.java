package com.STC.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iEmployeeRepo extends JpaRepository<Employee,Integer> {
    List<Employee> findByManagerId(int managerId);
    Employee findByUsername(String username);
    Employee getRefrenceByUsername(String username);
}
