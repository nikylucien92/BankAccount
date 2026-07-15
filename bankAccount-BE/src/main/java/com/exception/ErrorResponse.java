package com.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

//Rappresenta la classe che viene restituita al frontend quando si verifica un errore

@Data
@AllArgsConstructor
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;


}
