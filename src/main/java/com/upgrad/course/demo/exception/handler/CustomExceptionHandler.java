package com.upgrad.course.demo.exception.handler;

import com.upgrad.course.demo.dto.ErrorResponse;
import com.upgrad.course.demo.exception.MissingAuthHeaderException;
import com.upgrad.course.demo.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String NO_RECORDS_FOUND = "NO_RECORDS_FOUND";
    private String BAD_REQUEST = "BAD_REQUEST";

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(
            RecordNotFoundException ex, WebRequest req) {
        List<String> errorDetails = new ArrayList<String>();
        errorDetails.add(ex.getLocalizedMessage());
        ErrorResponse response = new ErrorResponse(NO_RECORDS_FOUND, errorDetails);

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    public final ResponseEntity<ErrorResponse> handleBadInputException(
            MissingAuthHeaderException ex, WebRequest req) {
        List<String> errorDetails = new ArrayList<String>();
        errorDetails.add(ex.getLocalizedMessage());
        ErrorResponse response = new ErrorResponse(BAD_REQUEST, errorDetails);

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
