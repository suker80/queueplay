package com.example.queueplay.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtils {
    private static final String key = "secret";
    private static final long exp = 60L * 60 * 24 * 365 * 1000;

    public String createTokens(String email, Collection<? extends GrantedAuthority> authorities) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("roles", authorities);
        return createTokens(map);
    }

    public String createTokens(Map<String, Object> claims) {
        return createTokens(Jwts.claims(claims));
    }

    public String createTokens(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public boolean validateTokens(String token) {
        String[] s = token.split(" ");
        token = s[1];
        try {
            return !isExpired(token);
        } catch (JwtException e) {
            return false;
        }
    }

    public Claims getAllClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    private boolean isExpired(String token) {
        Claims claims = getAllClaims(token);
        Date expiration = claims.getExpiration();
        Date now = new Date();
        return !now.after(expiration);
    }
}
