package com.example.queueplay.user;

import com.example.queueplay.jwt.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final JwtTokenUtils jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        Map<String, Object> attributes = ((DefaultOAuth2User) authentication.getPrincipal()).getAttributes();
        Map<String, Object> claim = new HashMap<>(attributes);

        String tokens = jwtTokenUtil.createTokens(claim);

        String targetUrl = determineTargetUrl(request, response, authentication);
        log.info("target url {}", targetUrl);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
        response.setHeader("Authorization", "Bearer " + tokens);
    }
}
