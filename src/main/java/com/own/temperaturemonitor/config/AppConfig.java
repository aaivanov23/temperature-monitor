package com.own.temperaturemonitor.config;

import com.own.temperaturemonitor.messagesender.MessageSender;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public MessageSender messageSender() {
        return new MessageSender(new RestTemplateBuilder());
    }
}
