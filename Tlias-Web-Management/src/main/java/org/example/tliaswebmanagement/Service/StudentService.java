package org.example.tliaswebmanagement.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Student;
import org.example.tliaswebmanagement.EntityClass.StudentQueryData;
import org.example.tliaswebmanagement.EntityClass.StudentQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    StudentQueryData findStudentData(StudentQueryParam studentQueryParam);
    Student findStudentById(Integer id);
    void deleteStudentById(List<Integer> ids);
    void insertStudentData(Student studentData);
    void updateStudentData(Student studentData);
    void updateStudentViolationData(Integer id,Integer score);
}
