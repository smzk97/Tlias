package org.example.tliaswebmanagement.Exception;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理器

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常
    @ExceptionHandler
    public Result GlobalException(Exception e){
        log.error("程序出错",e);
        String ExceptionString = e.toString();
        return Result.Defeat(ExceptionString);
    }

    // DuplicateKeyException异常
    @ExceptionHandler
    public Result DuplicateException(DuplicateKeyException e){
        String message = e.getMessage();
        log.error("程序出错，{}",message);
        int index = message.indexOf("Duplicate entry");
        String exactMessage = message.substring(index);
        String[] messageLists = exactMessage.split(" ");
        return Result.Defeat(messageLists[2] + "重复");
    }

    // DepartmentDeleteException异常
    @ExceptionHandler
    public Result DepartmentException(BusinessException e){
        log.info("业务异常，{}",e.getMessage());
        return Result.Defeat(e.getMessage());
    }
}
