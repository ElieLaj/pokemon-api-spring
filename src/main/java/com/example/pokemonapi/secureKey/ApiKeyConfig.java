package com.example.pokemonapi.secureKey;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiKeyConfig {

    @Value("${apiKey}")
    private String apiKey;

    @Value("${apiKeyFullAccess}")
    private String apiKeyFullAccess;

    @PostConstruct
    public void init() {
        System.out.println("Standard API Key: " + apiKey);
        System.out.println("Full Access API Key: " + apiKeyFullAccess);
    }

    public String getApiKey() {
        System.out.println("apiKey: " + apiKey);
        return apiKey;
    }

    public String getApiKeyFullAccess() {
        System.out.println("apiKeyFullAccess: " + apiKeyFullAccess);
        return apiKeyFullAccess;
    }
}
