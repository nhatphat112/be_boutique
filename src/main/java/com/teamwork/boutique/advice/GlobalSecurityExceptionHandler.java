//package com.teamwork.boutique.advice;
//
//import com.teamwork.boutique.payload.response.BaseResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalSecurityExceptionHandler {
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<BaseResponse> handleAccessDeniedException(AccessDeniedException ex) {
//        System.out.println("Check AccessDeniedException");
//        BaseResponse baseResponse = new BaseResponse();
//        baseResponse.setStatusCode(403);
//        baseResponse.setMessage("Access denied");
//        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
//    }
//}

