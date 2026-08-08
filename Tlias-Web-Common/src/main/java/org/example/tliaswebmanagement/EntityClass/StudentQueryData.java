package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

// 班级列表查询返回对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryData {
    private long total;
    private List<Student> rows;
}
