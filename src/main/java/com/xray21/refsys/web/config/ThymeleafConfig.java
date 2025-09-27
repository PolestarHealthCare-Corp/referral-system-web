package com.xray21.refsys.web.config;

import com.xray21.refsys.web.util.ThymeleafFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig {

	@Bean(name = "phoneFormatter")
	public ThymeleafFormatter thymeleafViewFormatter() {
		return new ThymeleafFormatter();
	}
}
