package com.upgrad.course.demo.exceptions.handler;

import com.upgrad.course.demo.exceptions.RecordNotFoundException;
import com.upgrad.course.demo.dto.ErrorResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  private String NO_RECORDS_FOUND = "NO_RECORDS_FOUND";
  private String BAD_REQUEST = "BAD_REQUEST";

  @ExceptionHandler(RecordNotFoundException.class)
  public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException e , WebRequest req){

    List<String> errorDetails = new ArrayList<String>();
    errorDetails.add(e.getLocalizedMessage());
    ErrorResponse response = new ErrorResponse(NO_RECORDS_FOUND, errorDetails);

    return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
  }


  protected  ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders httpHeaders,HttpStatus httpStatus ,  WebRequest webRequest) {
    Map<String, Object> body = new LinkedHashMap<>();

    body.put("status", httpStatus.value());

    List<String> errors  = ex.getBindingResult().getFieldErrors()
        .stream().map( x -> x.getDefaultMessage()).collect(
        Collectors.toList());

    body.put("error", errors);

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
}
