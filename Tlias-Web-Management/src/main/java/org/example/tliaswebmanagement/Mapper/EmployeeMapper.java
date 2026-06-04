package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> queryByParameters(Integer start, Integer pageSize);

    Long queryByParametersTotal();
}
