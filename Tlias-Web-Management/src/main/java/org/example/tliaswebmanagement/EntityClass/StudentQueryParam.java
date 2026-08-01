package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 查询学生信息参数对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    private String name;        // 学生姓名
    private Integer degree;     // 学历
    private Integer classId;    // 班级id
    private Integer page = 1;       // 页码
    private Integer pageSize = 10;   // 每页记录数
}
