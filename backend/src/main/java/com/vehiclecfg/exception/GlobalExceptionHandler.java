package com.vehiclecfg.exception;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ================= USER =================

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(

            UserNotFoundException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                HttpStatus.NOT_FOUND.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // ================= MODEL =================

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleModelNotFound(

            ModelNotFoundException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                HttpStatus.NOT_FOUND.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // ================= INVOICE =================

    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInvoiceNotFound(

            InvoiceNotFoundException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                HttpStatus.NOT_FOUND.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // ================= COMPONENT =================

    @ExceptionHandler(ComponentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleComponentNotFound(

            ComponentNotFoundException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                HttpStatus.NOT_FOUND.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // ================= MANUFACTURER =================

    @ExceptionHandler(ManufacturerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleManufacturerNotFound(

            ManufacturerNotFoundException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                HttpStatus.NOT_FOUND.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // ================= SEGMENT =================

    @ExceptionHandler(SegmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSegmentNotFound(

            SegmentNotFoundException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                HttpStatus.NOT_FOUND.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // ================= INVOICE DETAIL =================

    @ExceptionHandler(InvoiceDetailNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInvoiceDetailNotFound(

            InvoiceDetailNotFoundException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                HttpStatus.NOT_FOUND.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // ================= UNAUTHORIZED =================

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorized(

            UnauthorizedException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.UNAUTHORIZED.value(),

                HttpStatus.UNAUTHORIZED.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);

    }

    // ================= VALIDATION =================

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(

            MethodArgumentNotValidException ex,

            HttpServletRequest request) {

        FieldError fieldError = ex.getBindingResult().getFieldError();

        String message = fieldError != null
                ? fieldError.getDefaultMessage()
                : "Validation Failed";

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.BAD_REQUEST.value(),

                HttpStatus.BAD_REQUEST.name(),

                message,

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    // ================= BAD JSON =================

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(

            HttpMessageNotReadableException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.BAD_REQUEST.value(),

                HttpStatus.BAD_REQUEST.name(),

                "Invalid Request Body",

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    // ================= DUPLICATE =================

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(

            DataIntegrityViolationException ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.CONFLICT.value(),

                HttpStatus.CONFLICT.name(),

                "Duplicate Data Found",

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);

    }

    // ================= ALL OTHER EXCEPTIONS =================

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(

            Exception ex,

            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.INTERNAL_SERVER_ERROR.value(),

                HttpStatus.INTERNAL_SERVER_ERROR.name(),

                ex.getMessage(),

                request.getRequestURI()

        );

        ex.printStackTrace();

        return new ResponseEntity<>(

                error,

                HttpStatus.INTERNAL_SERVER_ERROR

        );

    }

}