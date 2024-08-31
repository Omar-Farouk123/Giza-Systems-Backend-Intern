package com.STC.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>Register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse>Register(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
    return ResponseEntity.ok(authenticationService.forgotPassword(email));
    }
}
