package com.tyy.auth.application.impl;


import com.tyy.auth.application.TokenService;
import com.tyy.auth.domain.AuthorizedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    private static final String SECRET="abcdefg";
    private static final Long EXPIRED_TIME=604800000L;//1000*60*60*24*7 (7天)


    @Override
    public String GenerateToken(AuthorizedUser authorizedUser) {

        Map<String,String>claims=new HashMap<>();

        return Jwts.builder()
                .setSubject(authorizedUser.getUsername())
                .setExpiration(getExpiredTime())
                .signWith(SignatureAlgorithm.HS512,SECRET)
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
