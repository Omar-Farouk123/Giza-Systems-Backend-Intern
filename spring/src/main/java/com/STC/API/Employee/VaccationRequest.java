package com.STC.API.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccationRequest {
    private int employee_id;
    private String start_date;
    private String end_date;
    private String req_date;
    private String status;
}
