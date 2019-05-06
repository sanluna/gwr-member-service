package com.sanluna;

import com.sanluna.security.principal.GWRTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@SpringBootApplication
@EnableResourceServer
public class MemberServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceStarter.class, args);
    }

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public void setJwtAccessTokenConverter(JwtAccessTokenConverter jwtAccessTokenConverter) {
        JwtAccessTokenConverter tokenConverter = new GWRTokenConverter();
        jwtAccessTokenConverter.setAccessTokenConverter(tokenConverter);
    }

    @Configuration
    public class AuthorizationSecurityConfigurer extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .cors().and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/status/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/members/", "/members").permitAll()
                    .anyRequest().authenticated();
        }
    }

}
