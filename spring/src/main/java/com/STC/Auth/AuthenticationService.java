package com.STC.Auth;

import com.STC.Exceptions.ApiRequestException;
import com.STC.Security.JWTService;
import com.STC.Users.Users;
import com.STC.Users.iUsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final iUsersRepo usersRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        Users user=usersRepo.findByUsername(request.getUsername())
                .orElseThrow();
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()) || usersRepo.findByUsername(request.getUsername()).isEmpty()){
            throw new ApiRequestException("Wrong username or password");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .Token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        if(usersRepo.findByUsername(request.getUsername()).isPresent() ){
           throw new ApiRequestException("Username already in use");
        }
        if(!Objects.equals(request.getRole(), "admin") && !Objects.equals(request.getRole(), "manager") && !Objects.equals(request.getRole(), "employee")) {
            throw new ApiRequestException("Invalid role");
        }
        Users user=new Users(request.getUsername(), passwordEncoder.encode(request.getPassword()),request.getRole(),request.getDepartment(),request.getManager_id());
//        var user=User.builder()
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()),
//                .build();
        usersRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .Token(jwtToken)
                .build();
    }
}

