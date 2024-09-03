package com.STC.API.Employee;

import com.STC.Attendences.Attendances;
import com.STC.Attendences.iAttendencesRepo;
import com.STC.Employee.Employee;
import com.STC.Employee.iEmployeeRepo;
import com.STC.Requests.Requests;
import com.STC.Requests.iRequestRepo;
import com.STC.Security.JWTService;
import com.STC.Users.Users;
import com.STC.Users.iUsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/employee")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;
    @PostMapping("/saveAttendence")
    public String saveAttendence(@RequestBody AttendenceRequest request){
        return employeeService.saveAttendence(request);
    }
    @PostMapping("/requestVacation")
    public String requestVacation(@RequestBody VaccationRequest request){
       return employeeService.requestVacation(request);
    }
}
