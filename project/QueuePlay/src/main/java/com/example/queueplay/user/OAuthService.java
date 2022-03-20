package com.example.queueplay.user;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class OAuthService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    public OAuthService() {
        super();
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("{}", userRequest);
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        User user = userRepository.findByEmail(oAuth2User.getAttribute("email"));

        if (user == null) {

            registerNew(oAuth2User);
        }


        return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "email");

    }

    private User registerNew(OAuth2User userInfo) {
        Map<String, Object> attributes = userInfo.getAttributes();
        User build = User.builder()
                .email((String) attributes.get("sub"))
                .role("ROLE_USER")
                .picture((String) attributes.get("picture"))
                .name((String) attributes.get("name"))
                .build();

        return userRepository.save(build);
    }


}
