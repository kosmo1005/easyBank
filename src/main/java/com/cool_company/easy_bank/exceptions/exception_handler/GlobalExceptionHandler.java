package com.cool_company.easy_bank.exceptions.exception_handler;

import com.cool_company.easy_bank.dto.ErrorResponseDto;
import com.cool_company.easy_bank.exceptions.ValidationErrorResponse;
import com.cool_company.easy_bank.exceptions.WalletNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ValidationErrorResponse> validationEx(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        return ResponseEntity.status(400).body(new ValidationErrorResponse(errors));
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponseDto> handleInvalidUUID(Exception ex) {
        String errorMessage = "Maybe invalid UUID or something else";
        return ResponseEntity.status(400).body(new ErrorResponseDto(errorMessage));
    }

    @ExceptionHandler(value = WalletNotFoundException.class)
    protected ResponseEntity<ErrorResponseDto> handleNotFound(Exception ex) {
        String errorMessage = String.format("%s", ex.getMessage());
        return ResponseEntity.status(404).body(new ErrorResponseDto(errorMessage));
    }

    @ExceptionHandler(value = {RuntimeException.class, NullPointerException.class})
    protected ResponseEntity<ErrorResponseDto> handleInternalServerError(Exception ex) {
        String errorMessage = String.format("%s", ex.getMessage());
        return ResponseEntity.status(500).body(new ErrorResponseDto(errorMessage));
    }
}
