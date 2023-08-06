package com.teamwork.boutique.utils;

import com.teamwork.boutique.exception.CustomException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtHelper {
    // @Value:lấy giá trị của key khai báo bên application.yml/properties
    @Value("${jwt.secret.key}")
    public String secretKey;
    // Mã hoá
    public String generateToken(String data) {
        //lấy key
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        String token = Jwts.builder()
                .setSubject(data)
                .signWith(key)
                .compact();
        return token;
    }
    // giải mã
    public Claims decodeToken(String token) {
        //lấy key
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        //giải mã token
        Claims claims = null;
        try {
           claims= Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build().parseClaimsJws(token)
                    .getBody();
        }catch (SignatureException customException){
//            throw new CustomException("Don't decoded token.");z
        }
        return claims;
    }
}
