package com.exception;

import java.time.LocalDateTime;


public class ApiError {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
