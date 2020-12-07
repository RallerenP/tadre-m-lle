package com.mchg.tadremoelle.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class Config implements WebMvcConfigurer {
    private final GetUserResolver getUserResolver;

    public Config(GetUserResolver getUserResolver) {
        this.getUserResolver = getUserResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(getUserResolver);
    }
}
