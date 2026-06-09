package org.example.tliaswebmanagement.Service.Ipl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryParam;
import org.example.tliaswebmanagement.EntityClass.EmployeeWorkExperience;
import org.example.tliaswebmanagement.Mapper.EmployeeMapper;
import org.example.tliaswebmanagement.Mapper.EmployeeWorkExperienceMapper;
import org.example.tliaswebmanagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceIpl implements EmployeeService {

    private EmployeeMapper employeeMapper;
    private EmployeeWorkExperienceMapper employeeWorkExperienceMapper;
    @Autowired
    public EmployeeServiceIpl(EmployeeMapper employeeMapper,EmployeeWorkExperienceMapper employeeWorkExperienceMapper) {
        this.employeeMapper = employeeMapper;
        this.employeeWorkExperienceMapper = employeeWorkExperienceMapper;
    }

    @Override
    public EmployeeQueryData queryByParameters(EmployeeQueryParam employeeQueryParam) {
        PageHelper.startPage(employeeQueryParam.getPage(),employeeQueryParam.getPageSize());
        List<Employee> employeeQueryData = employeeMapper.queryByParameters(employeeQueryParam);
        Page<Employee> PageData = (Page<Employee>) employeeQueryData;
        return new EmployeeQueryData(PageData.getTotal(),PageData.getResult());
    }

    @Override
    public void dataInsert(Employee employee) {
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setPassWord("123456");
        employeeMapper.EmployeeDataInsert(employee);

        List<EmployeeWorkExperience> employeeWorkExperiences = employee.getEmployeeWorkExperiences();
        if(!CollectionUtils.isEmpty(employeeWorkExperiences)){
            employeeWorkExperiences.forEach(em->{
                em.setEmployeeId(employee.getId());
            });
            employeeWorkExperienceMapper.EmployeeWorkExperienceDataInsert(employeeWorkExperiences);
        }

    }

}
