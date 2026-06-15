package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// 员工工作经历

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWorkExperience {
    private Integer id;            // id自增值
    private Integer employeeId;    // 用户id
    private LocalDate startTime;   // 入职时间
    private LocalDate endTime;     // 离职时间
    private String company;        // 公司名称
    private String job;            // 职位
}
