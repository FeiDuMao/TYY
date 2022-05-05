package normal;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Classname Token
 * @Date 2022/4/7 15:55
 * @Created by taoyuanyuan
 */
public class Token {


    public String LoginProcess( ) {
        return Jwts.builder()
                .setExpiration(getExpireDate())
                .setSubject("tyy")
                .signWith(SignatureAlgorithm.HS512, "123")
                .compact();
    }


    private Date getExpireDate() {
        long expireDate = LocalDate.now().plusDays(7).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new Date(expireDate);
    }

    private boolean checkToken(String token){
        Object body = Jwts.parser().setSigningKey("123").parse(token).getBody();
        return true;
    }



    @Test
    public void test(){
        String s = LoginProcess();
        checkToken(s);
    }


}
