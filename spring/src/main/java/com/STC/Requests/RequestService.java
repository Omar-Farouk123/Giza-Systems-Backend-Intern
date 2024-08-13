package com.STC.Requests;

import com.STC.Employee.iEmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private final iRequestRepo requestRepo;
    private final iEmployeeRepo employeeRepo;
    public RequestService(iRequestRepo requestRepo, iEmployeeRepo employeeRepo) {
        this.requestRepo = requestRepo;
        this.employeeRepo = employeeRepo;
    }

    public void populateRequests(){
        String[] status={"app","not Approved"};
        int empno;
        for(int i=1;i<2;i++)
            for(int j=1;j<=100;j++){
                empno=(j%100)+1;
                Requests requests=new Requests(j,employeeRepo.findById(empno),i+"/8/2024",((int)(Math.random()*31)+1)+"/8/2024","31/7/2024","app");
        }

    }

}
