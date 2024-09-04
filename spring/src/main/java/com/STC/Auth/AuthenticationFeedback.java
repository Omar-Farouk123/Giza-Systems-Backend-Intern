package com.STC.Auth;

import com.STC.Users.Users;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationFeedback {
    private  AuthenticationResponse   authenticationResponse;
    private  Users user;
}
