package com.lucassilvs.featuretoggle.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("localstack")
@EnableConfigurationProperties
public class LocalStackProperties {

    @Value("${config.aws.dynamodb.url}")
    private  String localstackUrl;

    @Value("${config.aws.region}")
    private  String localstackRegion;

    @Value("${config.aws.dynamodb.access-key}")
    private  String accessKey;

    @Value("${config.aws.dynamodb.secret-key}")
    private  String secretKey;

    public String getLocalstackUrl() {
        return localstackUrl;
    }

    public String getLocalstackRegion() {
        return localstackRegion;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
