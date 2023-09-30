package com.example.ArtHub;
import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class CloudinaryConfig {
    private final String CLOUD_NAME = "dlka73klc";
    private final String API_KEY = "393693335493931";
    private final String API_SECRET = "-TKAp_G9qRVS_L7_gwW9k_BZZAM";
    @Bean
    public Cloudinary cloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name",CLOUD_NAME);
        config.put("api_key",API_KEY);
        config.put("api_secret",API_SECRET);

        return new Cloudinary(config);
    }
}
