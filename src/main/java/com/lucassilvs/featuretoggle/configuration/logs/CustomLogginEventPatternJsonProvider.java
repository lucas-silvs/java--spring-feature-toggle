package com.lucassilvs.featuretoggle.configuration.logs;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonFactory;
import net.logstash.logback.composite.AbstractPatternJsonProvider;
import net.logstash.logback.pattern.AbstractJsonPatternParser;

public class CustomLogginEventPatternJsonProvider extends AbstractPatternJsonProvider<ILoggingEvent> {


    public CustomLogginEventPatternJsonProvider() {
    }

    protected AbstractJsonPatternParser<ILoggingEvent> createParser(JsonFactory jsonFactory) {
        return new CustomLogginEventJsonPatternParser(this.getContext(), jsonFactory);
    }
}
