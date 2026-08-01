package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 班级信息

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    private Integer id;                // ID,主键
    private String name;               // 班级名称
    private String room;               // 班级教室
    private LocalDate beginDate;       // 开课时间
    private LocalDate endDate;         // 结课时间
    private Integer masterId;          // 班主任ID
    private Integer subject;           // 学科
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间

    private String status;             // 状态（未开班、已开班、已结课）
}