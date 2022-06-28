package com.example.queueplay.jwt;

import com.example.queueplay.user.User;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private static final String KEY_ROLES = "roles";
    private final JwtTokenUtils jwtTokenUtils;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Claims claims = jwtTokenUtils.getAllClaims(((JwtAuthenticationToken) authentication).getToken());
        Collection<? extends GrantedAuthority> grantedAuthorities = createGrantedAuthorities(claims);

        User user = User.builder().email((String) claims.get("email")).build();
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(grantedAuthorities, "");
        jwtAuthenticationToken.setDetails(user);
        jwtAuthenticationToken.setAuthenticated(true);
        return jwtAuthenticationToken;
    }

    private Collection<? extends GrantedAuthority> createGrantedAuthorities(Claims claims) {
        List roles = (List) claims.get(KEY_ROLES);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Object role : roles) {
            grantedAuthorities.add(() -> (String) role);
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(JwtAuthenticationToken.class);
    }
}
