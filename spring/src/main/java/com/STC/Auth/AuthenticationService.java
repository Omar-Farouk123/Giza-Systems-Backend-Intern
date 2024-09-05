package com.STC.Auth;

import com.STC.Exceptions.ApiRequestException;
import com.STC.Manager.iManagerRepo;
import com.STC.Security.JWTService;
import com.STC.Users.Users;
import com.STC.Users.iUsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final iUsersRepo usersRepo;
    private final iManagerRepo managerRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthenticationFeedback authenticate(AuthenticationRequest request) {
        if(usersRepo.findByUsername(request.getUsername()).isEmpty()){
            throw new ApiRequestException("Username or Password is incorrect");
        }
        Users user=usersRepo.findByUsername(request.getUsername())
                .orElseThrow();
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()) || usersRepo.findByUsername(request.getUsername()).isEmpty()){
            throw new ApiRequestException("Username or Password is incorrect");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        var jwtToken = jwtService.generateToken(user);
         AuthenticationResponse response=AuthenticationResponse.builder()
                .Token(jwtToken)
                .build();
        return new AuthenticationFeedback(response,user);
    }

    public AuthenticationResponse register(RegisterRequest request) {
        if(usersRepo.findByUsername(request.getUsername()).isPresent() ){
           throw new ApiRequestException("Username already in use");
        }
        if(usersRepo.findByMail(request.getMail()).isPresent() ){
            throw new ApiRequestException("Mail already in use");
        }

        if(!Objects.equals(request.getRole(), "admin") && !Objects.equals(request.getRole(), "manager") && !Objects.equals(request.getRole(), "employee")) {
            throw new ApiRequestException("Invalid role");
        }
        if(managerRepo.findById(request.getManager_id()).isEmpty()){
            throw new ApiRequestException("Manager Id not found");
        }

        Users user=new Users(request.getUsername(), request.getMail(), passwordEncoder.encode(request.getPassword()),request.getRole(),request.getDepartment(),request.getManager_id());
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

    public String forgotPassword(String email) {
        Users user = usersRepo.findByMail(email)
                .orElseThrow();
        String token = jwtService.generateToken(user);
        emailService.sendPasswordResetEmail(user.getMail(), token);
        return"Password reset email sent";
    }
    public AuthenticationResponse refreshToken(String token){
        if(jwtService.isTokenExpired(token)){
            throw new ApiRequestException("token is expired");
        }
        String username= jwtService.extractUsername(token);
        Users user= usersRepo.findByusername(username);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .Token(jwtToken)
                .build();
    }
}

