package com.swgr.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Student OPEN API",
                version = "1.0.0",
                description = "Student OPEN API Documentation",
                contact = @Contact(
                        name = "Nitendra Kumar",
                        email = "knitendra5371@gmail.com",
                        url = "prakash.com"
                ),
                license = @License(
                        name = "Apache..."
                )
        ),
        externalDocs = @ExternalDocumentation(
                url = "LearnCodeWithDev.com"
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "Student OPEN API url"
        )
)
public class SwaggerConfig {
}
