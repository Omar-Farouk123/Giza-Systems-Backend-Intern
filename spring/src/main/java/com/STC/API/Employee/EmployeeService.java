package com.STC.API.Employee;

import com.STC.Attendences.Attendances;
import com.STC.Attendences.iAttendencesRepo;
import com.STC.Employee.Employee;
import com.STC.Employee.iEmployeeRepo;
import com.STC.Requests.Requests;
import com.STC.Requests.iRequestRepo;
import com.STC.Security.JWTService;
import com.STC.Users.iUsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final iAttendencesRepo attendencesRepo;
    private final iEmployeeRepo employeeRepo;
    private final iUsersRepo usersRepo;
    private final iRequestRepo requestRepo;
    private final JWTService jwtService;

    public String saveAttendence(AttendenceRequest request){
        Attendances attendance=new Attendances();
        attendance.setEmployee(employeeRepo.getReferenceById(request.employee_id));
        attendance.setCheckIn_time(request.check_in);
        attendance.setCheckOut_time(request.check_out);
        attendance.setStatus(request.status);
        attendance.setDate(request.date);
        attendance.setType(request.type);
        attendencesRepo.save(attendance);
        return "Attendence saved";
    }
    public String requestVacation( VaccationRequest request){
        Employee employee=employeeRepo.getReferenceById(request.getEmployee_id());
        Requests vac=new Requests(employee,request.getStart_date(),request.getEnd_date(),request.getReq_date(),request.getStatus());
        requestRepo.save(vac);
        return "Request saved";
    }
}
