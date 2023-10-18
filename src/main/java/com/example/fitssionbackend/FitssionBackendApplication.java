package com.example.fitssionbackend;

import com.example.fitssionbackend.product.ProductRequestArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@EnableJpaAuditing
@RequiredArgsConstructor
@SpringBootApplication
public class FitssionBackendApplication extends WebMvcConfigurationSupport {

	private final ProductRequestArgumentResolver productRequestArgumentResolver;

	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(productRequestArgumentResolver);
	}

	public static void main(String[] args) {
		SpringApplication.run(FitssionBackendApplication.class, args);
	}

}
