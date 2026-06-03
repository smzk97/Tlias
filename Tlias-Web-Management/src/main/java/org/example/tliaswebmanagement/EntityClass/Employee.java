package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String userName;
    private String passWord;
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
}
