package com.avaliacao.config.handler;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorMessage {
	
    private HttpStatus status;
    private String message;
    private List<String> errors;

}
