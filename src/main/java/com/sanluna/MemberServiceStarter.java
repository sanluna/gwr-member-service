package com.sanluna;

import com.sanluna.commons.BeansAndConfigurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import sanluna.gwr.security.SecurityConfiguration;

@SpringBootApplication
@EnableResourceServer
@Import({BeansAndConfigurations.class, SecurityConfiguration.class})
public class MemberServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceStarter.class, args);
    }

}
