package com.refsys.adminweb.config;

import com.refsys.adminweb.util.ThymeleafFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig {

	@Bean(name = "phoneFormatter")
	public ThymeleafFormatter thymeleafViewFormatter() {
		return new ThymeleafFormatter();
	}
}
