package org.asahu.hub.study;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication(scanBasePackages = "org.asahu.hub.study")
@EnableAutoConfiguration
public class MainApplication {
	@Autowired
	private RequestMappingHandlerMapping requestHandlerMapping;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@PostConstruct
	public void requestMappings() {
		this.requestHandlerMapping.getHandlerMethods().forEach((key, value) -> {
			System.out.println(key + "->" + value);
		});
	}

}