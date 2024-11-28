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

    public String getApiKey() {
        System.out.println("Current Api key: " + apiKey);
        return apiKey;
    }

    public String getApiKeyFullAccess() {
        System.out.println("Current Full Access Api key: " + apiKeyFullAccess);
        return apiKeyFullAccess;
    }
}
