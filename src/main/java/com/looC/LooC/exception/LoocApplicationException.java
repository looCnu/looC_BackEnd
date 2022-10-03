package com.looC.LooC.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoocApplicationException extends RuntimeException{
    //에러처리
    private ErrorCode errorCode;
    private String message;


    @Override
    public String getMessage(){
        if (message == null) return errorCode.getMessage();
        return String.format("%s. %s", errorCode.getMessage(), message);
    }
}
