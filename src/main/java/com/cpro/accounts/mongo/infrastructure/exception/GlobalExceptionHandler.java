package com.cpro.accounts.mongo.infrastructure.exception;

import com.cpro.accounts.mongo.infrastructure.dto.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleException(Exception e, HttpServletRequest request) {
        log.error(" --- Exception.handleException ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDTO.onCreate(HttpStatus.INTERNAL_SERVER_ERROR.value(), List.of(), e.getMessage()));
    }
}
