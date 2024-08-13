package com.STC.Attendences;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Attendances {
    @Id
   private int id;
   private int user_id;
   private String date;
   private String checkIn_time;
   private String checkOut_time;
   private String status;

    public Attendances() {
    }

    public Attendances(int id, int user_id, String date, String checkIn_time, String checkOut_time, String status) {
        this.id = id;
        this.user_id = user_id;
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
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
