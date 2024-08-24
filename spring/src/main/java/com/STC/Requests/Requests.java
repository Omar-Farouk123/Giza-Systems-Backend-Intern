package com.STC.Requests;

import com.STC.Employee.Employee;
import com.STC.Manager.Manager;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_id_sequence")
    @SequenceGenerator(name = "my_id_sequence", sequenceName = "my_id_sequence", allocationSize = 1)
    private int id;
    @OneToOne
    private Employee employee;
    private String start_date;
    private String end_date;
    private String req_date;
    private String status;

    public Requests() {

    }

    public Requests(int j, Optional<Employee> byId, String startDate, String endDate, String reqDate, String app) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getUser_Id() {
        return employee;
    }

    public void setEmployee(int employee_id) {
        this.employee = employee;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getReq_date() {
        return req_date;
    }

    public void setReq_date(String req_date) {
        this.req_date = req_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Requests(int id, Employee employee, String start_date, String end_date, String req_date, String status) {
        this.id = id;
        this.employee = employee;
        this.start_date = start_date;
        this.end_date = end_date;
        this.req_date = req_date;
        this.status = status;

    }

}
