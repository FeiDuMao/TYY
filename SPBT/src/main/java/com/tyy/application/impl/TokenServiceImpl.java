package com.tyy.application.impl;


import com.google.common.collect.Maps;
import com.tyy.application.TokenService;
import com.tyy.application.entity.AuthorizedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TokenServiceImpl implements TokenService {

    private static final String SECRET="abcdefg";
    private static final Long EXPIRED_TIME=604800000L;


    @Override
    public String GenerateToken(AuthorizedUser authorizedUser) {

        Map<String,String>claims=new HashMap<>();

        return Jwts.builder()
                .setSubject(authorizedUser.getUsername())
                .setExpiration(getExpiredTime())
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }

    @Override
    public AuthorizedUser getUserFromToken(String token) {
        Claims claims = parseToken(token);
        String username = claims.getSubject();
        return new AuthorizedUser(username,token);
    }

    private Date getExpiredTime(){return new Date(System.currentTimeMillis()+EXPIRED_TIME);}

    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }




}
