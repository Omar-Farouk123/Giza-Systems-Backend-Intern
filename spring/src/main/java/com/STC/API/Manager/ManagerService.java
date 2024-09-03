package com.STC.API.Manager;

import com.STC.Employee.Employee;
import com.STC.Employee.iEmployeeRepo;
import com.STC.Exceptions.ApiRequestException;
import com.STC.Manager.iManagerRepo;
import com.STC.Requests.Requests;
import com.STC.Requests.iRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final iRequestRepo requestRepo;
    private final iEmployeeRepo employeeRepo;
    private final iManagerRepo managerRepo;

    public List<Requests> viewRequests( int manager_id){
        if(managerRepo.findById(manager_id).isEmpty()){
            throw new ApiRequestException("Manager id not found");
        }
        List<Requests> requests=new ArrayList<Requests>();
        List<Employee> employees=employeeRepo.findByManagerId(manager_id);

        for (Employee employee : employees) {
            requests.addAll(requestRepo.findAllByEmployee(employee));
        }
        return requests;
    }
    public String updateRequest(updateRequest request){
        if( requestRepo.findById(request.getRequest_id()).isEmpty()){
            throw new ApiRequestException("request not found");
        }
        Requests r= requestRepo.getReferenceById(request.getRequest_id());
        r.setStatus(request.getStatus());
        requestRepo.save(r);
        return "Request Updated Successfully";
    }

    public List<Employee> viewEmployees(int manager_id){
        if(managerRepo.findById(manager_id).isEmpty()){
            throw new ApiRequestException("Manager id not found");
        }
        return employeeRepo.findByManagerId(manager_id);
    }

}
