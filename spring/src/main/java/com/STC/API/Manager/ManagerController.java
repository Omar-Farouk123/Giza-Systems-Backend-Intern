package com.STC.API.Manager;

import com.STC.Employee.Employee;
import com.STC.Employee.iEmployeeRepo;
import com.STC.Manager.iManagerRepo;
import com.STC.Requests.Requests;
import com.STC.Requests.iRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final iRequestRepo requestRepo;
    private final iEmployeeRepo employeeRepo;
    private final iManagerRepo managerRepo;
@GetMapping("/viewRequests")
public List<Requests> viewRequests(@RequestParam int manager_id){
    List<Requests> requests=new ArrayList<Requests>();
    List<Employee> employees=employeeRepo.findByManagerId(manager_id);

    for (Employee employee : employees) {
        requests.addAll(requestRepo.findAllByEmployee(employee));
    }
    return requests;
    }
@PutMapping("updateRequest")
public String updateRequest(@RequestBody updateRequest request){
   Requests r= requestRepo.getReferenceById(request.getRequest_id());
   r.setStatus(request.getStatus());
   requestRepo.save(r);
    return "Request Updated Successfully";
}

@GetMapping("viewEmployees")
    public List<Employee> viewEmployees(@RequestParam int manager_id){
    return employeeRepo.findByManagerId(manager_id);
}

}
