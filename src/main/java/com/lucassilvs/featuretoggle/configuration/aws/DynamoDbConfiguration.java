package com.lucassilvs.featuretoggle.configuration.aws;

import com.lucassilvs.featuretoggle.configuration.properties.LocalStackProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@Profile("mongo")
public class DynamoDbConfiguration {

    @Autowired
    private LocalStackProperties properties;



    @Bean
    @Profile("aws")
    public DynamoDbClient dynamoDbClientAWS() {
        return DynamoDbClient.create();
    }

    @Bean
    @Profile("localstack")
    public DynamoDbClient dynamoDbClientLocalStack() throws URISyntaxException {


        AwsCredentials credentials = AwsBasicCredentials.create(properties.getAccessKey(), properties.getSecretKey());
        return DynamoDbClient.builder()
                .endpointOverride(new URI(properties.getLocalstackUrl()))
                .region(Region.of(properties.getLocalstackRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }


}
