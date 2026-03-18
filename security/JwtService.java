package com.example.user.security;

import com.example.user.dao.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET;


    public String generateToken(UserEntity d){
        return Jwts.builder().setSubject(d.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 100000))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }




//    public String extractUsername(String token){
//        return Jwts.parserBuilder()
//                .setSigningKey(SECRET.getBytes())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//
//    }








}
