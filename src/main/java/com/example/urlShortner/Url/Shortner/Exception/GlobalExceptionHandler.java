package com.example.urlShortner.Url.Shortner.Exception;

import com.example.urlShortner.Url.Shortner.Dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseDto> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ResponseDto<Object> errorDetails = new ResponseDto<Object>(0,ex.getMessage(),null);

        return new ResponseEntity<ResponseDto>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<ResponseDto> handleDataExceptions(Exception ex, WebRequest request) throws Exception {
        ResponseDto<Object> errorDetails = new ResponseDto<Object>(0,ex.getMessage(),null);
        return new ResponseEntity<ResponseDto>(errorDetails, HttpStatus.BAD_REQUEST);
    }


}
