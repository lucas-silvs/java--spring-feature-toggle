package com.lucassilvs.featuretoggle.configuration.logs;

import java.util.Arrays;
import java.util.List;

public class LogProperties {

    private List<String> fieldsToLog;

    public LogProperties(){

    }

    public LogProperties(List<String> fieldsToLog){
        this.fieldsToLog = fieldsToLog;
    }

    public LogProperties(String fieldsToLog) {
        this.fieldsToLog = Arrays.asList(fieldsToLog.split(","));
    }

    public List<String> getFieldsToLog() {
        return fieldsToLog;
    }

    public void setFieldsToLog(List<String> fieldsToLog) {
        this.fieldsToLog = fieldsToLog;
    }
}
