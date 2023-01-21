package com.lucassilvs.featuretoggle.exceptions;

import org.springframework.http.HttpStatus;

public class CredenciaisIncorretasException extends RuntimeException {
    private HttpStatus statusCode;

    private String developermessage;

    public CredenciaisIncorretasException(HttpStatus statusCode, String developermessage) {
        this.statusCode = statusCode;
        this.developermessage = developermessage;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getDevelopermessage() {
        return developermessage;
    }
}
