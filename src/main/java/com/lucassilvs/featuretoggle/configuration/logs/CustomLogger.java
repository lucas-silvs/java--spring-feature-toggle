package com.lucassilvs.featuretoggle.configuration.logs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;

public class CustomLogger {

    private final Logger logger;

    private final ObjectMapper objectMapper;

    public CustomLogger(Logger logger) {
        this.logger = logger;
        this.objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        this.objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public void rawInfo(String s) { this.logger.info(s);}

    public void  rawInfo(String var1, Object var2){ this.logger.info(var1,var2);}


}
