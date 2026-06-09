package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String userName;
    private String passWord = "123456";
    private String name;
    private Integer gender;
    private String phoneNumber;
    private Integer job;
    private Double salary;
    private String image;
    private Integer departmentId;
    private LocalDate entryDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private List<EmployeeWorkExperience> employeeWorkExperiences;

}
