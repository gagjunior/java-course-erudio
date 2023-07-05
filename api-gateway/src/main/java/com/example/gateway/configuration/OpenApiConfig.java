package com.example.gateway.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OpenApiConfig {

	@Bean
	@Lazy(false)
	public List<GroupedOpenApi> apis(SwaggerUiConfigParameters configParameters,
			RouteDefinitionLocator definitionLocator) {

		List<RouteDefinition> definitions = definitionLocator.getRouteDefinitions().collectList().block();
		if (definitions != null) {
			definitions.stream().filter(df -> df.getId().matches(".*-service")).forEach(df -> {
				String name = df.getId();
				configParameters.addGroup(name);
				GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
			});
		}

		return new ArrayList<>();

	}
}
