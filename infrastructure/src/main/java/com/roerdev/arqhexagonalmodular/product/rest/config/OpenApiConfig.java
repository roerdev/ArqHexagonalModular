package com.roerdev.arqhexagonalmodular.product.rest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product API")
                        .version("0.0.1-SNAPSHOT")
                        .contact(new Contact()
                                .name("Erick Rodriguez")
                                .url("https://www.linkedin.com/in/roerdev/")
                                .email("erodriguezven@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")))
                ;
    }

}