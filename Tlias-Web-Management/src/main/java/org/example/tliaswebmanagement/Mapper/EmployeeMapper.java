package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryData;
import org.example.tliaswebmanagement.EntityClass.EmployeeQueryParam;
import org.example.tliaswebmanagement.EntityClass.LoginInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 关于员工基本信息Crud的接口管理
 */

@Mapper
public interface EmployeeMapper {
    /**
     * 根据参数查询员工信息
     * @param employeeQueryParam 查询参数对象
     * @return 员工信息对象
     */
    List<Employee> queryByParameters(EmployeeQueryParam employeeQueryParam);

    /**
     * 新增员工信息
     * @param employee 员工信息对象
     */
    void EmployeeDataInsert(Employee employee);

    /**
     * 根据id值删除员工信息
     * @param ids 员工id列表
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void dataDelete(List<Integer> ids);

    /**
     * 根据id值查询员工信息
     * @param id 员工id值
     * @return 员工信息对象
     */
    Employee dataQueryById(Integer id);

    /**
     * 更新员工信息
     * @param employee 员工信息对象
     */
    void dataUpdate(Employee employee);

    /**
     * 根据user_name查询员工信息
     * @param employee 查询员工信息对象
     * @return 员工信息对象
     */
    LoginInfo dataQueryByUserName(Employee employee);
}
