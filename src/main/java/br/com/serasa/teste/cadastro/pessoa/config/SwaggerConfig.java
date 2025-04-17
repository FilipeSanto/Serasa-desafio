package br.com.serasa.teste.cadastro.pessoa.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Cadastro de pessoas")
                        .version("1.0.0")
                        .description("Esta é a documentação da API usando Swagger/OpenAPI"));
    }
}