package com.lucassilvs.featuretoggle.configuration.logs;

import ch.qos.logback.classic.spi.ILoggingEvent;
import net.logstash.logback.composite.JsonProviders;
import net.logstash.logback.composite.loggingevent.*;

public class CustomLoggingEventJsonProvider extends JsonProviders<ILoggingEvent> {

    public CustomLoggingEventJsonProvider() {
    }

    public void addTimestamp(LoggingEventFormattedTimestampJsonProvider provider) {
        this.addProvider(provider);
    }

    public void addMessage(MessageJsonProvider provider){
        this.addProvider(provider);
    }

    public void addRawMessage(RawMessageJsonProvider provider){
        this.addProvider(provider);
    }

    public void  addLoggerName(LoggerNameJsonProvider provider){
        this.addProvider(provider);
    }

    public void addThreadName(LoggingEventThreadNameJsonProvider provider){
        this.addProvider(provider);
    }

    public void addLogLevel(LogLevelJsonProvider provider){
        this.addProvider(provider);
    }

    public void addLogLevelValue(LogLevelValueJsonProvider provider){
        this.addProvider(provider);
    }

    public void addCallerData(CallerDataJsonProvider provider){
        this.addProvider(provider);
    }

    public void addStackTrace(StackTraceJsonProvider provider){this.addProvider(provider);}

    public void  addRootStackTraceElement(RootStackTraceElementJsonProvider provider){
        this.addProvider(provider);
    }

    public void addStackHash(StackHashJsonProvider provider){
        this.addProvider(provider);
    }

    public void addContextName(ContextNameJsonProvider provider){
        this.addProvider(provider);
    }

    public void addMdc(MdcJsonProvider provider){
        this.addProvider(provider);
    }

    public void addTags(TagsJsonProvider provider){
        this.addProvider(provider);
    }

    public void addLogstashMarkers(LogstashMarkersJsonProvider provider){
        this.addProvider(provider);
    }

    public void addPattern(CustomLogginEventPatternJsonProvider provider){
        this.addProvider(provider);
    }

    public void addArguments(ArgumentsJsonProvider provider){
        this.addProvider(provider);
    }

    public void addNestedField(LoggingEventNestedJsonProvider provider){
        this.addProvider(provider);
    }

    public void addThrowableClassName(ThrowableClassNameJsonProvider provider){
        this.addProvider(provider);
    }

    public void addThrowableMessage(ThrowableMessageJsonProvider provider){
        this.addProvider(provider);
    }

    public void addThrowableRootCauseClassName(ThrowableRootCauseClassNameJsonProvider provider){
        this.addProvider(provider);
    }

    public void addThrowableRootCauseMessage(ThrowableRootCauseMessageJsonProvider provider){
        this.addProvider(provider);
    }

}
