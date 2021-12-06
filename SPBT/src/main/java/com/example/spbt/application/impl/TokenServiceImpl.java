package com.example.spbt.application.impl;

import com.example.spbt.application.TokenService;
import com.example.spbt.application.entity.UnAuthorizedUser;
import com.example.spbt.application.exceptioin.TokenExpiredException;
import com.example.spbt.domain.AuthorizedUser;
import com.example.spbt.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {


    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expireTime}")
    private Long expireTime;


    @Override
    public void validateToken(String token) throws TokenExpiredException {
        Claims claims=parseToken(token);
        Date expiration = claims.getExpiration();

        if (expiration.before(new Date(System.currentTimeMillis()))){
            throw new TokenExpiredException("token has already expired!");
        }

    }


    @Override
    public String GenerateToken(AuthorizedUser authorizedUser) {
        return Jwts.builder()
                .setSubject(authorizedUser.getUsername())
                .setExpiration(getExpireDate())
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    //生成过期时间
    private Date getExpireDate(){
        return new Date(System.currentTimeMillis()+expireTime);
    }

    //解析令牌
    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }


    @Test
    public void jwtTest(){
        this.secret="secret";

        String token = Jwts.builder()
                .setSubject("tyy")
                .signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .compact();


        Claims claims = parseToken(token);
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());

    }

}
