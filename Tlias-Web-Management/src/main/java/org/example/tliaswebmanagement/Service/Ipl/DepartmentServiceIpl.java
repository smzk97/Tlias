package org.example.tliaswebmanagement.Service.Ipl;

import org.example.tliaswebmanagement.EntityClass.Department;
import org.example.tliaswebmanagement.Mapper.DepartmentMapper;
import org.example.tliaswebmanagement.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceIpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll(){
        return departmentMapper.findAll();
    }
}
