package com.inn.cafe.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.security.KeyRep.Type.SECRET;

@Service
public class JwtUtil {
//    private String secret="btechdays";
//private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
private static final String SECRET_KEY = "mysecretkey123456789012345678901234"; // Must be 32+ characters for HS256


    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return  extractClaims(token,Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAlLClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAlLClaims(String token){
        return Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

//    public String generateToken(String username,String role){
//        Map<String,Object> claims= new HashMap<>();
//        claims.put("role",role);
//        return createToken(claims,username);
//    }
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
//        claims.put("roles", userDetails.getAuthorities()); // Inject roles
        claims.put("roles", userDetails.getAuthorities()); // Inject roles
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String,Object>claims,String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}







