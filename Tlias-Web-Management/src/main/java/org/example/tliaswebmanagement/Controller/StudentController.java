package org.example.tliaswebmanagement.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.Annotation.OperateLogRecord;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.EntityClass.Student;
import org.example.tliaswebmanagement.EntityClass.StudentQueryData;
import org.example.tliaswebmanagement.EntityClass.StudentQueryParam;
import org.example.tliaswebmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    /**
     * 查看学员列表信息
     * @param studentQueryParam 查询学员信息参数对象
     * @return 成功结果对象
     */
    @GetMapping("")
    public Result findStudentData(StudentQueryParam studentQueryParam){
        StudentQueryData studentQueryData = studentService.findStudentData(studentQueryParam);
        return Result.Success(studentQueryData);
    }

    /**
     * 根据id查看学员信息
     * @param id 学员列表信息主键
     * @return 成功结果对象
     */
    @GetMapping("/{id}")
    public Result findStudentById(@PathVariable Integer id){
        Student studentData = studentService.findStudentById(id);
        return Result.Success(studentData);
    }

    /**
     * 根据id值删除学员信息（可批量）
     * @param ids 学员信息主键列表
     * @return 成功结果对象
     */
    @OperateLogRecord
    @DeleteMapping("/{ids}")
    public Result deleteStudentById(@PathVariable List<Integer> ids){
        studentService.deleteStudentById(ids);
        return Result.Success();
    }

    /**
     * 新增学员信息
     * @param studentData 学员信息对象
     * @return 成功结果对象
     */
    @OperateLogRecord
    @PostMapping("")
    public Result insertStudentData(@RequestBody Student studentData){
        studentService.insertStudentData(studentData);
        return Result.Success();
    }

    /**
     * 更新学员信息
     * @param studentData 学员信息对象
     * @return 成功结果对象
     */
    @OperateLogRecord
    @PutMapping("")
    public Result updateStudentData(@RequestBody Student studentData){
        studentService.updateStudentData(studentData);
        return Result.Success();
    }

    /**
     * 修改学员的违纪数据
     * @param id 学员数据主键
     * @param score 违纪扣除分数
     * @return 成功结果对象
     */
    @OperateLogRecord
    @PutMapping("/violation/{id}/{score}")
    public Result updateStudentData(@PathVariable Integer id,@PathVariable Integer score){
        studentService.updateStudentViolationData(id,score);
        return Result.Success();
    }
}
