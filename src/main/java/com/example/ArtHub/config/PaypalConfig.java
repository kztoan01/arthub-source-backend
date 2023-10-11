package com.example.ArtHub.config;

import com.paypal.base.rest.OAuthTokenCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaypalConfig {
    @Value("${paypal.mode}")
    private String mode;

    @Value("${paypal.client.app}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(clientId, clientSecret, mode);
        return context;
    }

}
