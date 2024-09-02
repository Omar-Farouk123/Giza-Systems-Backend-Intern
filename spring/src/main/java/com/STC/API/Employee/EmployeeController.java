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
    private final iAttendencesRepo attendencesRepo;
    private final iEmployeeRepo employeeRepo;
    private final iUsersRepo usersRepo;
    private final iRequestRepo requestRepo;
    private final JWTService jwtService;
    @PostMapping("/saveAttendence")
    public String saveAttendence(@RequestBody AttendenceRequest request){
        Attendances attendance=new Attendances();
        attendance.setEmployee(employeeRepo.getReferenceById(request.employee_id));
        attendance.setCheckIn_time(request.check_in);
        attendance.setCheckOut_time(request.check_out);
        attendance.setStatus(request.status);
        attendance.setDate(request.date);
        attendencesRepo.save(attendance);
        return "Attendence saved";
    }
    @PostMapping("/requestVacation")
    public String requestVacation(@RequestBody VaccationRequest request){
        Employee employee=employeeRepo.getReferenceById(request.getEmployee_id());
        Requests vac=new Requests(employee,request.getStart_date(),request.getEnd_date(),request.getReq_date(),request.getStatus());
        requestRepo.save(vac);
        return "Request saved";
    }
    @GetMapping("viewDetails")
    public Users getEmployee(@RequestParam String token){
        String username= jwtService.extractUsername(token);
        Users users=usersRepo.findByusername(username);
        return users;
    }
}
