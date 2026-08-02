package org.example.tliaswebmanagement.Service.Ipl;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Department;
import org.example.tliaswebmanagement.Exception.BusinessException;
import org.example.tliaswebmanagement.Mapper.DepartmentMapper;
import org.example.tliaswebmanagement.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DepartmentServiceIpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll(){
        return departmentMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        Integer count = departmentMapper.queryCountByDepartmentId(id);
        if(count>0){
            throw new BusinessException("该部门下有员工，不能删除");
        }
        departmentMapper.deleteById(id);
    }

    @Override
    public void insertByName(Department department){
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());
        log.info("新增的部门数据为：{}",department);
        departmentMapper.insertByName(department);
    }

    @Override
    public List<Department> queryById(Integer id) {
        return departmentMapper.queryById(id);
    }

    @Override
    public void Update(Department department) {
        department.setUpdateTime(LocalDateTime.now());
        log.info("更改的部门数据内容为：{}",department);
        departmentMapper.Update(department);
    }
}
