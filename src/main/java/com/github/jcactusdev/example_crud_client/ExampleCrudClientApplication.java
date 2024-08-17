package com.github.jcactusdev.example_crud_client;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExampleCrudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleCrudClientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		return new RestTemplate(factory);
	}
}
