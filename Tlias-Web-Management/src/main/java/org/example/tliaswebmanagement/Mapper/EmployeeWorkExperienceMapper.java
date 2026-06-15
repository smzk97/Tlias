package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.EmployeeWorkExperience;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 关于员工工作经历信息Crud的接口管理
 */

@Mapper
public interface EmployeeWorkExperienceMapper {

    /**
     * 新增员工工作经历信息
     * @param employeeWorkExperience 员工工作经历对象
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void EmployeeWorkExperienceDataInsert(List<EmployeeWorkExperience> employeeWorkExperience);

    /**
     * 根据id值删除员工工作经历信息
     * @param ids 员工id值列表
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void dataDelete(List<Integer> ids);

}
