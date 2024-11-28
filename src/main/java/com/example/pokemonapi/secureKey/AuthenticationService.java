package com.example.pokemonapi.secureKey;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("Injected ApiKeyConfig: " + apiKeyConfig);
        System.out.println("ApiKey: " + apiKeyConfig.getApiKey());
        System.out.println("ApiKeyFullAccess: " + apiKeyConfig.getApiKeyFullAccess());
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        System.out.println("apiKey: " + apiKey);
        if (apiKey == null) {
            throw new BadCredentialsException("Missing API Key");
        }

        if (apiKey.equals(apiKeyConfig.getApiKey())) {
            return new ApiKeyAuthentication(apiKey, AuthorityUtils.createAuthorityList("ROLE_LIMITED"));
        }

        if (apiKey.equals(apiKeyConfig.getApiKeyFullAccess())) {
            return new ApiKeyAuthentication(apiKey, AuthorityUtils.createAuthorityList("ROLE_FULL_ACCESS"));
        }

        throw new BadCredentialsException("Invalid API Key");
    }
}

