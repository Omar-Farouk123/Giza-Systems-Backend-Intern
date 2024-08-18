package com.STC.Services.Signin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static javax.crypto.Cipher.SECRET_KEY;

public class Jwt {
    private static final Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final int min= 60;
    public static String generateToken(int id){
        var now = Instant.now();
        return Jwts.builder()
                .setSubject(id+"")
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(min,ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

    }
    public static String extractUsername(String token) {
        return getTokenBody(token).getSubject();
    }
    public static Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private static Claims getTokenBody(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (SignatureException | ExpiredJwtException e) { // Invalid signature or expired token
            throw new AccessDeniedException("Access denied: " + e.getMessage());
        }
    }

}
