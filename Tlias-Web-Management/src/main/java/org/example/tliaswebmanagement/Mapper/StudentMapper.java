package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.Student;
import org.example.tliaswebmanagement.EntityClass.StudentQueryParam;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 分页查询学员列表信息
     * @param studentQueryParam 查询学员数据参数对象
     * @return 学员信息列表
     */
    List<Student> findStudentData(StudentQueryParam studentQueryParam);

    /**
     * 根据id值查询学员信息
     * @param id 学员id
     * @return 学员信息对象
     */
    Student findStudentById(Integer id);

    /**
     * 根据id值删除学员信息（可批量）
     * @param ids 学员id值列表
     */
    void deleteStudentById(List<Integer> ids);

    /**
     * 新增学员列表信息
     * @param studentData 学员信息对象
     */
    void insertStudentData(Student studentData);

    /**
     * 更新学员信息
     * @param studentData 学员信息对象
     */
    void updateStudentData(Student studentData);

    /**
     * 更新学员违纪信息
     * @param id 学员id值
     * @param score 学员违纪扣除分数
     */
    void updateStudentViolationData(Integer id,Integer score);
}
