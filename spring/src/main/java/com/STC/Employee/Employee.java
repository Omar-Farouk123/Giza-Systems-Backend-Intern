package com.STC.Employee;

import com.STC.Manager.Manager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Employee {
    @Id

    private int id;
    private String username;
    private String password;

    private String department;
    @ManyToOne()
    @JoinColumn(name = "manager_id")
    @JsonIgnoreProperties({"username","password","department","employees","mail"})
    private Manager manager;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", manager=" + manager.getId() +
                '}';
    }

    public Employee(Integer id, String username, String password, String department, Manager manager) {
        this.id = id;
        this.username = username;
        this.password = password;

        this.department = department;
        this.manager = manager;
    }

    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
