package com.STC.Services.Signin;

import com.STC.Admin.Admin;
import com.STC.Admin.iAdminRepo;
import com.STC.Employee.Employee;
import com.STC.Employee.iEmployeeRepo;
import com.STC.Manager.Manager;
import com.STC.Manager.iManagerRepo;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional(readOnly =true)
public class UserService {
    private final iEmployeeRepo employeeRepo;
    private final iManagerRepo managerRepo;
    private final iAdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(iEmployeeRepo employeeRepomployeeRepo, iManagerRepo managerRepo, iAdminRepo adminRepo, PasswordEncoder passwordEncoder) {
        this.employeeRepo = employeeRepomployeeRepo;
        this.managerRepo = managerRepo;
        this.adminRepo = adminRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void signin(SignIn.SigninRequest request){
       int id= request.id();
        Optional<Employee> employee=employeeRepo.findById(id);
        Optional<Manager> manager=managerRepo.findById(id);
        Optional<Admin> admin=adminRepo.findById(id);
        if(employee.isPresent()|manager.isPresent()|admin.isPresent()){

        }

    }

}
