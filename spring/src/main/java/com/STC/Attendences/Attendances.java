package com.STC.Attendences;

import com.STC.Employee.Employee;
import jakarta.persistence.*;

@Entity
public class Attendances {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_id_sequence")
    @SequenceGenerator(name = "my_id_sequence", sequenceName = "my_id_sequence", allocationSize = 1)
   private int id;
    @ManyToOne
    private Employee employee;
   private String date;
   private String checkIn_time;
   private String checkOut_time;
   private String status;

    public Attendances() {
    }

    public Attendances( Employee employee, String date, String checkIn_time, String checkOut_time, String status) {
        this.employee = employee;
        this.date = date;
        this.checkIn_time = checkIn_time;
        this.checkOut_time = checkOut_time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckIn_time() {
        return checkIn_time;
    }

    public void setCheckIn_time(String checkIn_time) {
        this.checkIn_time = checkIn_time;
    }

    public String getCheckOut_time() {
        return checkOut_time;
    }

    public void setCheckOut_time(String checkOut_time) {
        this.checkOut_time = checkOut_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
