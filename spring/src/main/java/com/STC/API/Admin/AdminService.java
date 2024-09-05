package com.STC.API.Admin;

import com.STC.Employee.Employee;
import com.STC.Employee.iEmployeeRepo;
import com.STC.Exceptions.ApiRequestException;
import com.STC.Manager.Manager;
import com.STC.Manager.iManagerRepo;
import com.STC.Users.iUsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final iManagerRepo managerRepo;
    private final iEmployeeRepo employeeRepo;
    public String assignManagers(assignManagerRequest request){
        if(managerRepo.findById(request.getManager_id()).isEmpty()){
            throw new ApiRequestException("No manager with this id is found");
        }
        Manager manager = managerRepo.getReferenceById(request.getManager_id());
        List<Integer> employees=request.getEmployee_id();
        Employee employee;
        for(int i=0; i<employees.size(); i++){
            if(employeeRepo.findById(employees.get(i)).isEmpty()){
                throw new ApiRequestException("No employee with this id is found");
            }
            else{
                employee= employeeRepo.getReferenceById(employees.get(i));
                employee.setManager(manager);
                employeeRepo.save(employee);
            }
        }
        return "all Employee's manager have been updated successfully";
    }
}
