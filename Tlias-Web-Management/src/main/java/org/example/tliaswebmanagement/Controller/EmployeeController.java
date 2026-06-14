package org.example.tliaswebmanagement.Controller;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryParam;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    public Result QueryList(EmployeeQueryParam employeeQueryParam){
        EmployeeQueryData employeeQueryData = employeeService.queryByParameters(employeeQueryParam);
        return Result.Success(employeeQueryData);
    }

    @PostMapping("")
    public Result DataInsert(@RequestBody Employee employee){
        employeeService.dataInsert(employee);
        return Result.Success();
    }

    @DeleteMapping("")
    public Result DataDelete(@RequestParam List<Integer> ids){
        employeeService.dataDelete(ids);
        return Result.Success();
    }

    @GetMapping("/{id}")
    public Result DataQueryById(@PathVariable Integer id){
        Employee employee = employeeService.dataQueryById(id);
        return Result.Success(employee);
    }
}
