package boo.web.voting.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class WebhookConnfiguratiton {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
