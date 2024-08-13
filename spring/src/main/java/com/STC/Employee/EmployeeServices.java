package com.STC.Employee;

import com.STC.Manager.Manager;
import com.STC.Manager.iManagerRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {
    private final iEmployeeRepo employeeRepo;
    private final iManagerRepo managerRepo;

    public EmployeeServices(iEmployeeRepo employeeRepo, iManagerRepo managerRepo) {
        this.employeeRepo = employeeRepo;
        this.managerRepo = managerRepo;
    }
    public void populateEmployee(){
        for(int i=1;i<=10;i++){
            Manager m=new Manager(i,"Manager"+i,"Pass"+i,"Tech",null);
            managerRepo.save(m);
        }
        for(int i=1;i<=100;i++){
            Employee e = new Employee(i,"employee"+i,"pass"+i,"tech",managerRepo.getReferenceById((i%10)+1));
            employeeRepo.save(e);
        }
    }

}
