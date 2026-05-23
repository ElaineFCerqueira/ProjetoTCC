package com.example.api_db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map; // Faltava essa importação!

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> tratarConflito(IllegalArgumentException erro) {
        // Criando a resposta com o status 409 (Conflict) e a mensagem de erro no corpo
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", erro.getMessage()));
    }
}
