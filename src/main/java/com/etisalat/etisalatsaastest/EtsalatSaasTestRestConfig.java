package com.etisalat.etisalatsaastest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config file for rest template
 */
@Configuration
public class EtsalatSaasTestRestConfig {

    @Value("${etisalatSassTest.url}")
    private String url;
    @Value("${etisalatSassTest.userName}")
    private String userName;
    @Value("${etisalatSassTest.password}")
    private char[] password;

    @Bean
    public EtisalatSaasTestRestTemplate etisalatSaasRestTemplate() {
        return new RestTemplateBuilder()
                .basicAuthentication(this.userName, String.valueOf(this.password))
                .rootUri(this.url).build(EtisalatSaasTestRestTemplate.class);
    }

}
