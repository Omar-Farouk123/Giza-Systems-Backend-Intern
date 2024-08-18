package com.STC.History;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AttendanceHistory {
    @Id
    private int id;
    private int emp_id;
    private String date;
    private String checkIn_time;
    private String checkOut_time;
    private String status;

    public AttendanceHistory() {
    }

    public AttendanceHistory(int id, int emp_id, String date, String checkIn_time, String checkOut_time, String status) {
        this.id = id;
        this.emp_id = emp_id;
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

    public int getUser_id() {
        return emp_id;
    }

    public void setUser_id(int user_id) {
        this.emp_id = user_id;
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
