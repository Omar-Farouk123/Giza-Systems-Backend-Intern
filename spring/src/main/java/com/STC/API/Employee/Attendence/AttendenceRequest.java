package com.STC.API.Employee.Attendence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendenceRequest {
    String check_in;
    String check_out;
    String date;
    String status;
    int employee_id;
}
