package org.example.tliaswebmanagement.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public Result QueryList(Integer page,Integer pageSize){
        Integer start = (page-1)*pageSize;
        EmployeeQueryData employeeQueryData = employeeService.queryByParameters(start,pageSize);
        return Result.Success(employeeQueryData);
    }


}
