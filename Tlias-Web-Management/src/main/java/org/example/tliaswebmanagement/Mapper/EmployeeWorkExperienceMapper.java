package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.EmployeeWorkExperience;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Mapper
public interface EmployeeWorkExperienceMapper {
    void EmployeeWorkExperienceDataInsert(List<EmployeeWorkExperience> employeeWorkExperience);
}
