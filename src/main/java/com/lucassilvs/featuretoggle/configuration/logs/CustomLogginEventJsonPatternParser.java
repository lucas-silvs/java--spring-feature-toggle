package com.lucassilvs.featuretoggle.configuration.logs;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.pattern.PatternLayoutBase;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.wnameless.json.flattener.FlattenMode;
import com.github.wnameless.json.flattener.JsonFlattener;
import net.logstash.logback.composite.JsonReadingUtils;
import net.logstash.logback.pattern.LoggingEventJsonPatternParser;

import java.io.IOException;

public class CustomLogginEventJsonPatternParser extends LoggingEventJsonPatternParser {

    private final JsonFactory jsonFactory;

    private final ObjectMapper objectMapper;

    private final LogProperties logProperties;
    public CustomLogginEventJsonPatternParser(Context context, JsonFactory jsonFactory) {
        super(context, jsonFactory);
        this.logProperties = new LogProperties(context.getProperty("logProperties"));
        this.jsonFactory = jsonFactory;
        this.objectMapper = new ObjectMapper();
        this.addOperation("tryFlatJson", new TryFlatJsonOperation());
    }

    @Override
    protected PatternLayoutBase<ILoggingEvent> createLayout() {
        return null;
    }

    protected class TryFlatJsonOperation implements Operation<JsonNode>{

        protected TryFlatJsonOperation(){

        }


        @Override
        public JsonNode apply(String value) {
            try {
                String flatValue = new JsonFlattener(value)
                        .withSeparator('_')
                        .withFlattenMode(FlattenMode.KEEP_ARRAYS)
                        .flatten();
                JsonNode jsonNode = JsonReadingUtils.readFully(jsonFactory, flatValue);
                ObjectNode log = objectMapper.createObjectNode();
                logProperties.getFieldsToLog().forEach(f -> {
                    if(jsonNode.get(f) != null){
                        log.set(f, jsonNode.get(f));
                    }
                });
                return log;
            } catch (Exception e) {
                ObjectNode textLog = objectMapper.createObjectNode();
                textLog.put("text", value);
                return textLog;

            }
        }
    }
}
