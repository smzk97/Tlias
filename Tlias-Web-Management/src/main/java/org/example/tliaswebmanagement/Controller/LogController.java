package org.example.tliaswebmanagement.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.LogQueryData;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController
public class LogController {

    private LogService logService;
    @Autowired
    public LogController(LogService logService){
        this.logService = logService;
    }

    @GetMapping("/page")
    public Result queryLogData(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer pageSize){
        LogQueryData logQueryData = logService.queryLogData(page,pageSize);
        return Result.Success(logQueryData);
    }
}
