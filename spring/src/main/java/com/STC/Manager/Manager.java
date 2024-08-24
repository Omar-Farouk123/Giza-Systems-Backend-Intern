package com.STC.Manager;

import com.STC.Employee.Employee;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Manager {
    public Manager(int id, String username, String password,String department, List<Employee> employees) {
        this.id = id;
        this.username = username;
        this.password = password;

        this.department = department;
        this.employees = employees;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_id_sequence")
    @SequenceGenerator(name = "my_id_sequence", sequenceName = "my_id_sequence", allocationSize = 1)
    private int id;
    @Column(nullable = false,unique = true)
    private String username;
    private String password;

    private String department;

    public Manager() {

    }

    @OneToMany(cascade=CascadeType.ALL, mappedBy="manager")
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id && Objects.equals(username, manager.username) && Objects.equals(password, manager.password)  && Objects.equals(department, manager.department) && Objects.equals(employees, manager.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, department, employees);
    }
}
