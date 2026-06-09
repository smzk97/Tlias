package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.EmployeeWorkExperience;

import java.util.List;

@Mapper
public interface EmployeeWorkExperienceMapper {
    void EmployeeWorkExperienceDataInsert(List<EmployeeWorkExperience> employeeWorkExperience);
}
