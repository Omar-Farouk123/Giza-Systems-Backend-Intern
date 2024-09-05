package com.STC.API.Admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class assignManagerRequest {
    private int manager_id;
    private List<Integer> employee_id;

}
