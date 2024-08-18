package com.STC.Services.Signin;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("signin")
public class SignIn {
    public record SigninRequest(
            @NotBlank(message = "ID cannot be blank")
            int id,

            @NotBlank(message = "Password cannot be blank")
            @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
            String password) {}
    @PostMapping
    public ResponseEntity<Void> signin(@Valid @RequestBody SigninRequest request){
        UserService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
