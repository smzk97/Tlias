package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// 员工信息

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;                   // 员工id值
    private String userName;              // 员工用户名
    private String passWord = "123456";   // 员工密码
    private String name;                  // 员工姓名
    private Integer gender;               // 员工性别
    private String phoneNumber;           // 员工手机号
    private Integer job;                  // 员工职位
    private Double salary;                // 员工薪水
    private String image;                 // 员工头像
    private Integer departmentId;         // 员工部门
    private LocalDate entryDate;          // 员工入职时间
    private LocalDateTime createTime;     // 数据创建时间
    private LocalDateTime updateTime;     // 数据更新时间
    private List<EmployeeWorkExperience> employeeWorkExperiences;  // 员工工作经历
}
