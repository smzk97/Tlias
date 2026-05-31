package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.tliaswebmanagement.EntityClass.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department")
    List<Department> findAll();
}
