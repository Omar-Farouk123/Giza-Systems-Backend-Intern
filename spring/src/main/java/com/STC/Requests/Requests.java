package com.STC.Requests;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Requests {
    @Id
    private int id;
    private int user_Id;
    private String start_date;
    private String end_date;
    private String req_date;
    private String status;
    private int manager_id;

    public Requests() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
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

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public Requests(int id, int user_Id, String start_date, String end_date, String req_date, String status, int manager_id) {
        this.id = id;
        this.user_Id = user_Id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.req_date = req_date;
        this.status = status;
        this.manager_id = manager_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requests requests = (Requests) o;
        return id == requests.id && user_Id == requests.user_Id && manager_id == requests.manager_id && Objects.equals(start_date, requests.start_date) && Objects.equals(end_date, requests.end_date) && Objects.equals(req_date, requests.req_date) && Objects.equals(status, requests.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_Id, start_date, end_date, req_date, status, manager_id);
    }

}
