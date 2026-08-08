package org.example.tliaswebmanagement.Exception;

// 自定义非受检异常
public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
