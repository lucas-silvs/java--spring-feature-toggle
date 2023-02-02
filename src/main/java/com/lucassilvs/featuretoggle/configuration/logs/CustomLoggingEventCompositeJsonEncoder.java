package com.lucassilvs.featuretoggle.configuration.logs;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.joran.spi.DefaultClass;
import net.logstash.logback.composite.AbstractCompositeJsonFormatter;
import net.logstash.logback.composite.JsonProviders;
import net.logstash.logback.composite.loggingevent.LoggingEventCompositeJsonFormatter;
import net.logstash.logback.encoder.CompositeJsonEncoder;

public class CustomLoggingEventCompositeJsonEncoder extends CompositeJsonEncoder<ILoggingEvent> {

    public CustomLoggingEventCompositeJsonEncoder() {
    }

    protected AbstractCompositeJsonFormatter<ILoggingEvent> createFormatter() {
        return new LoggingEventCompositeJsonFormatter(this);
    }

    @DefaultClass(CustomLoggingEventJsonProvider.class)
    public void setProviders(JsonProviders<ILoggingEvent> jsonProvider){
        super.setProviders(jsonProvider);
    }
}
