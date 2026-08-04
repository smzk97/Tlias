package org.example.tliaswebmanagement.Service.Ipl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.EntityClass.*;
import org.example.tliaswebmanagement.Mapper.EmployeeMapper;
import org.example.tliaswebmanagement.Mapper.EmployeeWorkExperienceMapper;
import org.example.tliaswebmanagement.Service.EmployeeService;
import org.example.tliaswebmanagement.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Transactional(rollbackFor = Exception.class)
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void dataDelete(@RequestParam List<Integer> ids) {
        employeeMapper.dataDelete(ids);
        employeeWorkExperienceMapper.dataDelete(ids);
    }

    @Override
    public Employee dataQueryById(Integer id) {
        Employee employee = employeeMapper.dataQueryById(id);
        return employee;
    }

    @Override
    public LoginInfo LoginVerify(Employee employee) {
        LoginInfo loginInfo = employeeMapper.dataQueryByUserName(employee);
        if(loginInfo != null){
            Map<String,Object> map = new HashMap<>();
            map.put("id",loginInfo.getId());
            map.put("userName",loginInfo.getUserName());
            String token = JwtUtil.generateToken(map);
            loginInfo.setToken(token);
            return loginInfo;
        }
        return null;
    }

    @Override
    public void dataUpdate(Employee employee){
        employee.setUpdateTime(LocalDateTime.now());
        employeeMapper.dataUpdate(employee);
        List<EmployeeWorkExperience> employeeWorkExperience = employee.getEmployeeWorkExperiences();
        if(!CollectionUtils.isEmpty(employeeWorkExperience)){
            employeeWorkExperience.forEach(emwe->{
                emwe.setEmployeeId(employee.getId());
            });
        }
        employeeWorkExperienceMapper.dataDelete(Arrays.asList(employee.getId()));
        employeeWorkExperienceMapper.EmployeeWorkExperienceDataInsert(employeeWorkExperience);
    }
}
