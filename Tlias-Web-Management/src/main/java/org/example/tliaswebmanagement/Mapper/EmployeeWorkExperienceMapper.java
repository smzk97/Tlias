package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.EmployeeWorkExperience;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface EmployeeWorkExperienceMapper {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void EmployeeWorkExperienceDataInsert(List<EmployeeWorkExperience> employeeWorkExperience);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void dataDelete(List<Integer> ids);

}
