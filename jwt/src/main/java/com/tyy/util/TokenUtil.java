package com.tyy.util;

import com.tyy.entity.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.cert.X509CertSelector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    private static final String CLAIM_KEY_CREATED="created";
    private static final String CLAIM_KEY_USERNAME="sub";

    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expireTime}")
    private Long expireTime;



    //根据UserDetail生成令牌
    public String CreateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_CREATED,new Date());
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        //claims.put("Authority",userDetails.getAuthorities());

        return  GenerateToken(claims);
    }

    private String GenerateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    //生成过期时间(7天)
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expireTime*1000);
    }

    //验证令牌是否有效
    public boolean validateToken(String token,UserDetails userDetails){
        Claims claims=parseToken(token);
        String username= claims.getSubject();
        return username.equals(userDetails.getUsername())&&!isTokenExpired(token);
    }

    //判断令牌是否过期
    private boolean isTokenExpired(String token) {
        Date expireTime=getExpiration(token);
        return expireTime.before(new Date());//时间在前则为过期
    }



    public String refreshToken(String token){
        Claims claims=parseToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return GenerateToken(claims);
    }


    //解析令牌
    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
    //获取登录时间
    public Date getLoginDate(String token){
        Claims claims = parseToken(token);
        return new Date((Long) claims.get(CLAIM_KEY_CREATED));
    }
    //获取失效时间
    public Date getExpiration(String token){
        return parseToken(token).getExpiration();
    }
    //获取用户名
    public String getUsername(String token){
        return (String) parseToken(token).get(CLAIM_KEY_USERNAME);
    }

    @Test
    public void test(){
        this.secret="tyyyy";
        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0eXkiLCJjcmVhdGV" +
                "kIjoxNjI3NjMxNTMzNTA4LCJleHAiOjE2MjgyMzYzMzN9.8t0dbTJ4H2HMzy0p2l-wl2TC4-hs7s-ymMniFtqH1Ck";

        Claims claims = parseToken(token);
        System.out.println(claims);
        System.out.println(claims.getSubject());

        System.out.println(DateFormatUtils.format(getLoginDate(token), "MM-dd HH:mm"));
        System.out.println(DateFormatUtils.format(getExpiration(token), "MM-dd HH:mm"));


        System.out.println(claims.get(CLAIM_KEY_USERNAME));

    }



}
