package org.example.tliaswebmanagement.Service.Ipl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.EntityClass.Student;
import org.example.tliaswebmanagement.EntityClass.StudentQueryData;
import org.example.tliaswebmanagement.EntityClass.StudentQueryParam;
import org.example.tliaswebmanagement.Mapper.StudentMapper;
import org.example.tliaswebmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceIpl implements StudentService {

    private StudentMapper studentMapper;
    @Autowired
    public StudentServiceIpl(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentQueryData findStudentData(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> StudentData = studentMapper.findStudentData(studentQueryParam);
        Page<Student> pageData = (Page<Student>) StudentData;
        return new StudentQueryData(pageData.getTotal(),pageData.getResult());
    }

    @Override
    public Student findStudentById(Integer id) {
        Student studentData = studentMapper.findStudentById(id);
        return studentData;
    }

    @Override
    public void deleteStudentById(List<Integer> ids) {
        studentMapper.deleteStudentById(ids);
    }

    @Override
    public void insertStudentData(Student studentData) {
        studentData.setCreateTime(LocalDateTime.now());
        studentData.setUpdateTime(LocalDateTime.now());
        studentMapper.insertStudentData(studentData);
    }

    @Override
    public void updateStudentData(Student studentData) {
        studentData.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudentData(studentData);
    }

    @Override
    public void updateStudentViolationData(Integer id, Integer score) {
        studentMapper.updateStudentViolationData(id,score);
    }
}
