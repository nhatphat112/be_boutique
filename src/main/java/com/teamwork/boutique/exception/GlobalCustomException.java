package com.teamwork.boutique.exception;

import com.teamwork.boutique.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice

public class GlobalCustomException {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(e.getStatusCode());
        baseResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handAccessDeniedException(Exception e){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
}
