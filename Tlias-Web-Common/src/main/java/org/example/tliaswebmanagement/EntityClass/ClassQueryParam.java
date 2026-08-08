package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// 班级列表分页查询参数对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassQueryParam {
    private String name;            // 班级名称
    private LocalDate beginTime;    // 匹配开始时间（结课时间）
    private LocalDate endTime;      // 匹配结束时间（结课时间）
    private Integer page = 1;       // 分页查询的页数
    private Integer pageSize = 10;  // 分页查询的每页记录数
}
