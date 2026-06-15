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

    /**
     * 根据翻页参数查询所有员工信息
     * @param employeeQueryParam 查询对象
     * @return 成功结果对象
     */
    @GetMapping("/list")
    public Result QueryList(EmployeeQueryParam employeeQueryParam){
        EmployeeQueryData employeeQueryData = employeeService.queryByParameters(employeeQueryParam);
        return Result.Success(employeeQueryData);
    }

    /**
     * 新增员工基本信息
     * @param employee 新增的员工信息，通过请求体传递
     * @return 成功结果对象
     */
    @PostMapping("")
    public Result DataInsert(@RequestBody Employee employee){
        employeeService.dataInsert(employee);
        return Result.Success();
    }

    /**
     * 根据id值删除员工信息
     * @param ids 员工id列表
     * @return 成功结果对象
     */
    @DeleteMapping("")
    public Result DataDelete(@RequestParam List<Integer> ids){
        employeeService.dataDelete(ids);
        return Result.Success();
    }

    /**
     * 根据id值查询员工信息
     * @param id 员工id值
     * @return 成功结果对象
     */
    @GetMapping("/{id}")
    public Result DataQueryById(@PathVariable Integer id){
        Employee employee = employeeService.dataQueryById(id);
        return Result.Success(employee);
    }

    /**
     * 更新员工基本信息
     * @param employee 员工信息对象
     * @return 成功结果对象
     */
    @PutMapping("")
    public Result DataUpdate(@RequestBody Employee employee){
        employeeService.dataUpdate(employee);
        return Result.Success();
    }
}
