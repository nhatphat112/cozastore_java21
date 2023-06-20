package com.cybersoft.cozastore_java21.exception;

import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomException {
    @ExceptionHandler(UserNotFondException.class)
    public ResponseEntity<?> handleUserNotFond(Exception e){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("");
        baseResponse.setStatusCode(401);
        baseResponse.setData(e.getMessage());

        return new ResponseEntity<>(baseResponse, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(CustomFileNotFoundException.class)
    public ResponseEntity<?> handleCustomFileNotFond(Exception e){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("");
        baseResponse.setStatusCode(500);
        baseResponse.setData(e.getMessage());

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(Exception e){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("");
        baseResponse.setStatusCode(500);
        baseResponse.setData(e.getMessage());

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
