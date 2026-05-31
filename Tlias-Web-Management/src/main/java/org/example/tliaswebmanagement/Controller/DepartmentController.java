package org.example.tliaswebmanagement.Controller;

import org.apache.catalina.User;
import org.example.tliaswebmanagement.EntityClass.Department;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/lists")
    public Result DepartmentList(){
        List<Department> department = departmentService.findAll();
        return Result.Success(department);
    }
}
