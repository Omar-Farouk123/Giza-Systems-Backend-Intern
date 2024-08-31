package com.STC.API.Employee.AttendenceVacc;

import com.STC.Attendences.Attendances;
import com.STC.Attendences.iAttendencesRepo;
import com.STC.Employee.iEmployeeRepo;
import com.STC.Requests.Requests;
import com.STC.Requests.iRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final iAttendencesRepo attendencesRepo;
    private final iEmployeeRepo employeeRepo;
    private final iRequestRepo requestRepo;
    @PostMapping("/saveAttendence")
    public String saveAttendence(@RequestBody AttendenceRequest request){
        Attendances attendance=new Attendances();
        attendance.setEmployee(employeeRepo.getReferenceById(request.employee_id));
        attendance.setCheckIn_time(request.check_in);
        attendance.setCheckOut_time(request.check_out);
        attendance.setStatus(request.status);
        attendance.setDate(request.date);
        attendencesRepo.save(attendance);
        return "Done";
    }
    @PostMapping("/requestVacation")
    public String requestVacation(@RequestBody VaccationRequest request){
        Requests vac=new Requests();
        vac.setEmployee(request.getEmployee_id());
        vac.setStatus(request.getStatus());
        vac.setStart_date(request.getStart_date());
        vac.setEnd_date(request.getEnd_date());
        vac.setReq_date(request.getReq_date());
        requestRepo.save(vac);
        return "Done";
    }
}
