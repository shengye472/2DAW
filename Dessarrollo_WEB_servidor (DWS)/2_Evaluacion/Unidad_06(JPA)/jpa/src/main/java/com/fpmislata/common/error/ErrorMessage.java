package com.fpmislata.common.error;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessage {
    private final String error;
    private final String message;

    public ErrorMessage(Exception e) {
        this.error = e.getClass().getSimpleName();
        this.message = e.getMessage();
    }
}
