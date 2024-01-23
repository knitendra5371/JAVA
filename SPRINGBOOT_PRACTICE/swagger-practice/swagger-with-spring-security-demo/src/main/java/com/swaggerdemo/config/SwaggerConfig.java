package com.swaggerdemo.config;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*@SecurityScheme(
        name = "scheme1",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Student OPEN API",
                version = "1.0.0",
                description = "Student OPEN API Documentation",
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Nitendra Kumar",
                        email = "knitendra5371@gmail.com",
                        url = "prakash.com"
                ),
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "Apache..."
                )
        ),
        externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
                url = "LearnCodeWithDev.com"
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "Student OPEN API url"
        )
)*/
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        String schemeName="basicScheme";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(schemeName))
                .components(new Components()
                        .addSecuritySchemes(schemeName,new SecurityScheme()
                                .name(schemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .bearerFormat("JWT")
                                .scheme("bearer")))
                .info(new Info()
                        .title("Student OPEN API")
                        .description("Student OPEN API Documentation")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Nitendra kumar")
                                .email("knitendra5371@gmail.com")
                                .url("prakash.com"))
                        .license(new License().name("Apache....")))

                .externalDocs(new ExternalDocumentation().url("CodingConceptWithDev.com")); // CodingConceptWithDev
    }


}
