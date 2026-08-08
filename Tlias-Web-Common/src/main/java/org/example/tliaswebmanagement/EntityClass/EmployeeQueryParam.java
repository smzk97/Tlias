package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

// 查询参数对象

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeQueryParam {
    private Integer page = 1;            // 查询页数
    private Integer pageSize = 10;       // 查询页数大小
    private Integer gender;              // 查询性别
    private String name;                 // 查询姓名
    @DateTimeFormat(pattern = "yy-MM-dd")
    private String beginTime;            // 查询创建时间
    @DateTimeFormat(pattern = "yy-MM-dd")
    private String endTime;              // 查询更新时间
}
