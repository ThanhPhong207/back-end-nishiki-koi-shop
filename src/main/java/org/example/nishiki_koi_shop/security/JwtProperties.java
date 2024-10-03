package org.example.nishiki_koi_shop.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("app.security.jwt")
public class JwtProperties {
    private String accessSecret;
    private String refreshSecret;
    private String prefix;
    private String authHeader;
    private long accessExpiresAt;
    private long refreshExpiresAt;

}



