package com.STC.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    private final static String secret_key="R0p4KF4nIrc0W9Hs0NN/gxyrG4yMR6BRCBVPIWldhTiNKg0sMZklGJaLZb1i14BT1BHybguQXwRddH2WpHmtvvf9h1V9m4HmDsLvzQ6pU/0H311sSCA32sgg0Xr7sOXbJO4tYnSuxvoa5OWOo909qZ5hoWk9Ei0wveGIdWWwWNNHlL1/0m8lUG15FrRj/zVk+hDaNJxIlT1XxAr4fIfuSVYKPudi5u1npJP+sRI5odddmp4v4ORZdeHvfOu/8VCH5AIaxgMG9aJdbfXsK1ZuzjRDEYHRiURX1e1J+YFJPrw+W9Ka4j2JpRSYjWxg1W+64MuleRT1prb1jdRRtuGqDHxiLyilf/4IEO1uJVZuArg=\n";
    public String extractUsername(String jwtToken) {
        return extractClaim(jwtToken,Claims::getSubject);
    }
    public <T> T extractClaim(String jwtToken, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Claims extractAllClaims(String jwtToken){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyByte= Decoders.BASE64.decode(secret_key);
        return Keys.hmacShaKeyFor(keyByte);
    }
}
