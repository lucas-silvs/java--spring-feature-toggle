package com.lucassilvs.featuretoggle.configuration;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
// Habilitando documentação REST API
//@EnableFF4jSwagger
// The class should be on classpath : FF4jDispatcherServlet
@ConditionalOnClass({FF4jDispatcherServlet.class})
// Configurado após a configuração da classe FF4JConfig
@AutoConfigureAfter(FF4jConfig.class)
public class FF4JWebConsoleConfiguration extends SpringBootServletInitializer {

    /**
     * Definition of the servlet for web console
     */
    @Bean
    @ConditionalOnMissingBean
    public FF4jDispatcherServlet getFF4jDispatcherServlet(FF4j ff4j) {
        FF4jDispatcherServlet ff4jConsoleServlet = new FF4jDispatcherServlet();
        ff4jConsoleServlet.setFf4j(ff4j);
        return ff4jConsoleServlet;
    }

    /**
     * Mapping from FF4j to the endpoint you want
     * mapeamento do FF4J para o endpoint descrito
     */
    @Bean
    @SuppressWarnings({"rawtypes","unchecked"})
    public ServletRegistrationBean ff4jDispatcherServletRegistrationBean(FF4jDispatcherServlet ff4jDispatcherServlet) {
        return new ServletRegistrationBean(ff4jDispatcherServlet, "/ff4j-web-console/*");
    }
}
