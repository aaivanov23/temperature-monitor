package com.own.temperaturemonitor;

import com.own.temperaturemonitor.config.AppConfig;
import com.own.temperaturemonitor.messagesender.MessageSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TemperaturemonitorApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TemperaturemonitorApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		((MessageSender) context.getBean("messageSender")).getPostsPlainJSON();
	}

}
