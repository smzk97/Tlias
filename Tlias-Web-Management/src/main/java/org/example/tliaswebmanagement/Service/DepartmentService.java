package org.example.tliaswebmanagement.Service;

import org.example.tliaswebmanagement.EntityClass.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    void deleteById(Integer id);
    void insertByName(Department department);
    List<Department> queryById(Integer id);
    void Update(Department department);
}
