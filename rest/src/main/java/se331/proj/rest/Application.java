package se331.proj.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// students
				registry.addMapping("/students")
				.allowedOrigins("https://localhost:3000");
				registry.addMapping("/students/*")
				.allowedOrigins("https://localhost:3000");
				// advisors
				registry.addMapping("/advisors")
				.allowedOrigins("https://localhost:3000");
				registry.addMapping("/advisors/*")
				.allowedOrigins("https://localhost:3000");
				// **
				registry.addMapping("/**")
				.allowedOrigins("https://localhost:3000")
				.exposedHeaders("x-total-count");
			}
		};
	}
}
