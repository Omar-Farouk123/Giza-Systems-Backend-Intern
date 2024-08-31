package com.STC.Requests;

import com.STC.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iRequestRepo extends JpaRepository<Requests,Integer> {
    List<Requests> findAllByEmployee(Employee employee);
}
