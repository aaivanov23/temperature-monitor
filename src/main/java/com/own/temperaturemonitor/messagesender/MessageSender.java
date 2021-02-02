package com.own.temperaturemonitor.messagesender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageSender {
    @Value("${bot.token}")
    private String botToken;
    @Value("${bot.message}")
    private String message;
    @Value("${bot.chatId}")
    private String chatId;

    private final RestTemplate restTemplate;

    public MessageSender(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String getPostsPlainJSON() {
        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage?chat_id=" + chatId + "&parse_mode=Markdown&text=" + message;
        return this.restTemplate.getForObject(url, String.class);
    }

    public String getBotToken() {
        return botToken;
    }

    public String getMessage() {
        return message;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
