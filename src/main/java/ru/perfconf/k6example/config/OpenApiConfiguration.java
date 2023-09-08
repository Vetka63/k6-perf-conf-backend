package ru.perfconf.k6example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "K6 mock server",
                description = "Rest API для примеров НТ",
                version = "v1"))
@ConditionalOnProperty(value = "springdoc.api-docs.enabled", havingValue = "true")
@SuppressWarnings("HideUtilityClassConstructor")
@Configuration
public class OpenApiConfiguration {

}
