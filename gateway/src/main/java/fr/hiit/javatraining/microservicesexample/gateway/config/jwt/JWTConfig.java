package fr.hiit.javatraining.microservicesexample.gateway.config.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
@Getter
@Setter
public class JWTConfig {
    private String uri;
    private String header;
    private String prefix;
    private int expiration;
    private String secret;
}
