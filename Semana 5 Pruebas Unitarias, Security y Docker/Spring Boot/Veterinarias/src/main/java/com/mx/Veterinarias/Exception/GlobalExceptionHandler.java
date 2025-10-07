package com.mx.Veterinarias.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
@ControllerAdvice

public class GlobalExceptionHandler {
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        // Tomar solo el primer mensaje de error
	        String mensaje = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST) // 400
	                .body(mensaje); // aquí solo va el mensaje
	    }

}
