package org.example.tliaswebmanagement.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Class;
import org.example.tliaswebmanagement.EntityClass.ClassQueryData;
import org.example.tliaswebmanagement.EntityClass.ClassQueryParam;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/class")
@RestController
public class ClassController {
    private ClassService classService;
    @Autowired
    public ClassController(ClassService classService){
        this.classService = classService;
    }

    /**
     * 分页查询班级列表的信息
     * @param classQueryParam 班级列表查询对象
     * @return 成功结果对象
     */
    @GetMapping("")
    public Result findAllByPage(ClassQueryParam classQueryParam){
        log.info("分页查询班级列表信息");
        ClassQueryData classListData = classService.findAllByPage(classQueryParam);
        return Result.Success(classListData);
    }

    /**
     * 查询班级列表的信息
     * @return 成功结果对象
     */
    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有班级列表信息");
        List<Class> classListData = classService.findAll();
        return Result.Success(classListData);
    }

    /**
     * 根据id查询班级列表信息
     * @param id 班级列表的id值
     * @return 成功结果对象
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询班级列表信息");
        Class classData = classService.findById(id);
        return Result.Success(classData);
    }

}
