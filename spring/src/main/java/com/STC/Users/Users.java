package com.STC.Users;


import jakarta.persistence.*;


import java.util.Objects;
@Entity
public class Users {
@Id
@SequenceGenerator(
        name="customer_id_sequence",
        sequenceName ="seq",
        allocationSize =1

)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_id_sequence"
)
private int id;
private String username;
private String password;
private String role;
private String department;

    public Users(int id, String username, String password, String role, String department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.department = department;
    }

    public Users() {

    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(role, user.role) && Objects.equals(department, user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, department);
    }
}