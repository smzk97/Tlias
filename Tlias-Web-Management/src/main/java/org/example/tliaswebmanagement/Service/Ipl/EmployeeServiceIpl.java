package org.example.tliaswebmanagement.Service.Ipl;

import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;
import org.example.tliaswebmanagement.Mapper.EmployeeMapper;
import org.example.tliaswebmanagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIpl implements EmployeeService {

    private EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeServiceIpl(EmployeeMapper employeeMapper){
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeQueryData queryByParameters(Integer start,Integer pageSize) {
        Long total = employeeMapper.queryByParametersTotal();
        List<Employee> employeeList = employeeMapper.queryByParameters(start,pageSize);
        return new EmployeeQueryData(total,employeeList);
    }
}
