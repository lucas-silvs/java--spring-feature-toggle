package com.lucassilvs.featuretoggle.configuration;

import org.ff4j.FF4j;
import org.ff4j.core.FeatureStore;
import org.ff4j.dynamodb.feature.FeatureStoreDynamoDB;
import org.ff4j.dynamodb.property.PropertyStoreDynamoDB;
import org.ff4j.property.store.PropertyStore;
import org.ff4j.security.SpringSecurityAuthorisationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

/***
 * Bean responsavel pela configuração do FF4J, como conexão com banco, autoCreate, cache, etc.
 */
@Configuration
public class FF4jConfig {
    /**
     * Some logger.
     */
    // private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    @Bean
    public FF4j getFF4j(DynamoDbClient dynamoDbClient) {
        FF4j ff4j = new FF4j();


        FeatureStore featureStore = new FeatureStoreDynamoDB(dynamoDbClient);
        PropertyStore propertyStore = new PropertyStoreDynamoDB(dynamoDbClient);
        ff4j.setFeatureStore(featureStore);
        ff4j.setPropertiesStore(propertyStore);


        // ativando auditoria e monitoramento, valor padrão é false
        ff4j.audit(true);

        // quando uma feature não é encontrada, ela sera criada automaticamente, porem desabilitada
        ff4j.autoCreate(true);

        // definindo Role Base Access Control (Controle de Acesso Baseado em Funções), para isso é necessário um usuário logado
        ff4j.setAuthorizationsManager(new SpringSecurityAuthorisationManager());

        //cria uma camada de cache para aliviar o banco de dados
        //ff4j.cache([a cache Manager]);

        return ff4j;

    }
}
