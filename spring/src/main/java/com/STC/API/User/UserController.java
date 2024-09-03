package com.STC.API.User;

import com.STC.Security.JWTService;
import com.STC.Users.Users;
import com.STC.Users.iUsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/user")
@RequiredArgsConstructor
public class UserController {
    private final iUsersRepo usersRepo;
    private final JWTService jwtService;

    @GetMapping("viewDetails")
    public Users getEmployee(@RequestParam String token){
        String username= jwtService.extractUsername(token);
        return usersRepo.findByusername(username);
    }
}
