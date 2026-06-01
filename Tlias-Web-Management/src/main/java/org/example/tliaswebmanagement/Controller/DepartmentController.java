package org.example.tliaswebmanagement.Controller;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Department;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DepartmentController {

    private DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    /**
     * 处理查询所有部门数据的请求
     * @return 成功结果对象
     */
    @GetMapping("/lists")
    public Result DepartmentList(){
        log.info("查询部门列表所有信息");
        List<Department> department = departmentService.findAll();
        return Result.Success(department);
    }

    /**
     * 处理根据id删除相关部门的请求
     * @param id 部门ID
     * @return 成功结果对象
     */
    @DeleteMapping("/list")
    public Result DepartmentDelete(Integer id){
        log.info("根据id查询部门信息：{}",id);
        departmentService.deleteById(id);
        return Result.Success();
    }

    /**
     * 处理新增部门数据的请求
     * @param department 新增的部门名称
     * @return 成功结果对象
     */
    @PostMapping("/list")
    public Result DepartmentInsert(@RequestBody Department department){
        log.info("新增部门信息");
        departmentService.insertByName(department);
        return Result.Success();
    }

    /**
     * 处理根据id值查询部门数据的请求
     * @param id 部门ID
     * @return 成功结果对象
     */
    @GetMapping("/list/{id}")
    public Result DepartmentQueryById(@PathVariable("id") Integer id){
        log.info("根据id值查询部门信息：{}",id);
        List<Department> departments = departmentService.queryById(id);
        return Result.Success(departments);
    }

    /**
     * 处理更改部门数据的请求
     * @param department Department对象
     * @return 返回成功结果对象
     */
    @PutMapping("/list")
    public Result DepartmentUpdate(@RequestBody Department department){
        log.info("更改部门数据");
        departmentService.Update(department);
        return Result.Success();
    }


}
