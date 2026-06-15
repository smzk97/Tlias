package org.example.tliaswebmanagement.Service;

import org.apache.ibatis.annotations.Options;
import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryParam;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface EmployeeService {
    void dataUpdate(Employee employee);

    EmployeeQueryData queryByParameters(EmployeeQueryParam employeeQueryParam);

    void dataInsert(Employee employee);

    void dataDelete(List<Integer> ids);

    Employee dataQueryById(Integer id);
}
