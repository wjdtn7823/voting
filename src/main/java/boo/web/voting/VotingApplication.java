package boo.web.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class VotingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotingApplication.class, args);
    }

}
