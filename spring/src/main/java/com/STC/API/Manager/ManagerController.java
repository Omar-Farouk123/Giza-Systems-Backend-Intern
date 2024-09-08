package com.STC.API.Manager;

import com.STC.Employee.Employee;
import com.STC.Requests.Requests;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/viewRequests")
    public List<Requests> viewRequests(@RequestParam int manager_id) {
        return managerService.viewRequests(manager_id);
    }

    @PutMapping("/updateRequest")
    public String updateRequest(@RequestBody updateRequest request) {
        return managerService.updateRequest(request);
    }

    @GetMapping("/viewEmployees")
    public List<Employee> viewEmployees(@RequestParam int manager_id) {
        return managerService.viewEmployees(manager_id);

    }
}
