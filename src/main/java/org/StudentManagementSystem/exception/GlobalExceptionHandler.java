package org.StudentManagementSystem.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.StudentManagementSystem.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleResourseNotFoundException(ResourseNotFoundException ex,
                                                                        HttpServletRequest request) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO );
    }

    @ExceptionHandler(DuplicateResourseException.class)
    public ResponseEntity<ExceptionDTO> duplicateResourseException(DuplicateResourseException ex,
                                                                   HttpServletRequest request) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }
}
