package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> queryByParameters(EmployeeQueryParam employeeQueryParam);

    void EmployeeDataInsert(Employee employee);
}
