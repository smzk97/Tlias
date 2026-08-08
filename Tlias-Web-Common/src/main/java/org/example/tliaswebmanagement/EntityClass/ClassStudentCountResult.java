package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 班级人数统计
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassStudentCountResult {
    private List<Object> classList;
    private List<Object> dataList;
}
