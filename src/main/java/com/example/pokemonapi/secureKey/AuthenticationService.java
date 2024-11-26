package com.example.pokemonapi.secureKey;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";

    private static ApiKeyConfig apiKeyConfig;

    @Autowired
    public AuthenticationService(ApiKeyConfig apiKeyConfig) {
        AuthenticationService.apiKeyConfig = apiKeyConfig;
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !apiKey.equals(apiKeyConfig.getApiKey())) {
            throw new BadCredentialsException("Invalid API Key: " + AUTH_TOKEN_HEADER_NAME + " " + apiKey + " " + apiKeyConfig.getApiKey());
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
