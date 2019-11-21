package com.aumarbello.soflite.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private final Date timeStamp;
    private final String details;
    private final String message;

    public ExceptionResponse(Date timeStamp, String details, String message) {
        this.timeStamp = timeStamp;
        this.details = details;
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }
}
