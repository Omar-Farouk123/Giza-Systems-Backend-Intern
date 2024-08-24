package com.STC.API.Employee.Attendence;

import com.STC.Attendences.Attendances;
import com.STC.Attendences.iAttendencesRepo;
import com.STC.Employee.iEmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final iAttendencesRepo attendencesRepo;
    private final iEmployeeRepo employeeRepo;
    @PostMapping
    public String saveAttendence(@RequestBody AttendenceRequest request){
        Attendances attendance=new Attendances(1,employeeRepo.findById(request.employee_id)
                .orElseThrow()
                , request.date, request.check_in, request.check_out, request.status);
        attendencesRepo.save(attendance);
        return "Done";

    }
}
