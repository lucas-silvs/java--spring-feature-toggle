package com.lucassilvs.featuretoggle.configuration;

import org.ff4j.FF4j;
import org.ff4j.audit.repository.InMemoryEventRepository;
import org.ff4j.property.store.InMemoryPropertyStore;
import org.ff4j.store.InMemoryFeatureStore;
import org.ff4j.web.controller.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * Bean responsavel pela configuração do FF4J, como conexão com banco, autoCreate, cache, etc.
 */
@Configuration
public class FF4jConfig {
    /** Some logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Bean
    public FF4j getFF4j() {
        FF4j ff4j = new FF4j();

        /*
         * criando um armazenamento de features em memória
         */
        ff4j.setFeatureStore(new InMemoryFeatureStore());
        ff4j.setPropertiesStore(new InMemoryPropertyStore());
        ff4j.setEventRepository(new InMemoryEventRepository());

        // ativando auditoria e monitoramento, valor padrão é false
        ff4j.audit(true);

        // quando uma feature não é encontrada, ela sera criada automaticamente, porem desabilitada
        ff4j.autoCreate(true);

        // To define RBAC access, the application must have a logged user
        // definindo Role Base Access Control (Controle de Acesso Baseado em Funções), para isso é necessário um usuário logado
        //ff4j.setAuthManager(...);

        //cria uma camada de cache para aliviar o banco de dados
        //ff4j.cache([a cache Manager]);

        return ff4j;

    }
}
