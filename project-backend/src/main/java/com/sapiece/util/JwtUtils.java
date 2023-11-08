package com.sapiece.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author SAPiece
 * @Create 2023-11-08 12:24
 * @Package com.sapiece.util
 * @Project GraduationDesign
 * @Filename JwtUtils
 * @Version 1.0
 */
@Component
public class JwtUtils {
    @Value("${spring.security.jwt.key}")
    String key;
    @Value("${spring.security.jwt.expire-time}")
    int expire;
    public String createJwt(UserDetails details,int id,String username){
        Algorithm algorithm = Algorithm.HMAC256(key);
        Date expire = this.expireTime();
        return JWT.create()
                .withClaim("id",id)
                .withClaim("name",username)
                .withClaim("authorities",details.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .withExpiresAt(expire)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }
    public Date expireTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,expire*24);
        return calendar.getTime();
    }
}
