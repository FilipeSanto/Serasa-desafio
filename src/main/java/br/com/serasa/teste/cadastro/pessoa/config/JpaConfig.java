package br.com.serasa.teste.cadastro.pessoa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class JpaConfig {
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setEntityManagerFactoryInterface(jakarta.persistence.EntityManagerFactory.class);
        return factoryBean;
    }
}