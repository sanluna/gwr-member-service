package com.sanluna.gwr;

import com.sanluna.commons.BeansAndConfigurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ BeansAndConfigurations.class})
public class MemberServiceStarter {
    public static void main(String[] args) {
        SpringApplication.run(MemberServiceStarter.class, args);
    }

}
