package com.STC.API.Admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @PutMapping("/assignManagers")
    public String assignManagers(@RequestBody assignManagerRequest request) {

        return adminService.assignManagers(request);
    }
}
