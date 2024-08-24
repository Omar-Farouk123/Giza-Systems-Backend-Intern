package com.STC.Security;

import com.STC.Users.Users;
import com.STC.Users.iUsersRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JWTAuth extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final iUsersRepo usersRepo;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader=request.getHeader("Authorization");
        final String jwtToken;
        final String username;
        if(authHeader==null || !authHeader.startsWith(("Bearer"))){
            filterChain.doFilter(request,response);
            return;
        }
        jwtToken=authHeader.substring(7);
        username=jwtService.extractUsername(jwtToken);
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            Users user=usersRepo.findByUsername(username)
                    .orElseThrow();
            if(jwtService.isTokenValid(jwtToken,user)){
                UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
               SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
