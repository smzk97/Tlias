package org.example.tliaswebmanagement.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

// Jwt工具类
@Component
public class JwtUtil {
    private static final String KEY = "c2RmamtkZmpsa2RmamFsa2ZkamZsa2RmamFsa2ZkamZsa2RmamFsa2ZkamZsa2Zk";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(KEY.getBytes(StandardCharsets.UTF_8));
    private static final long EXPIRATION_TIME = 12 * 3600 * 1000;

    // 生成token
    public String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .signWith(SECRET_KEY,Jwts.SIG.HS256)
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    // 解析token
    public Claims verifyToken(String token){
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
