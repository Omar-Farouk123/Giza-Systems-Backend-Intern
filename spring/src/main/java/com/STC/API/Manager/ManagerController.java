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
public ResponseEntity<List<Requests>> viewRequests(@RequestParam int manager_id){
    List<Requests> requests=new ArrayList<Requests>();
    List<Employee> employees=new ArrayList<Employee>();
    for(int i=0;i<employees.size();i++){
        if(requestRepo.findAllByEmployee(employees.get(i)) != null){
           for (int j=0;j<requestRepo.findAllByEmployee(employees.get(i)).size();j++){
               requests.add(requestRepo.findAllByEmployee(employees.get(i)).get(j));
           }
        }
    }
    return ResponseEntity.ok(requests);
}

}
