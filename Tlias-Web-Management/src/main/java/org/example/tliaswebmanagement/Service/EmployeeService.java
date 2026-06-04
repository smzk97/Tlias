package org.example.tliaswebmanagement.Service;

import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeQueryData queryByParameters(Integer start,Integer pageSize);
}
