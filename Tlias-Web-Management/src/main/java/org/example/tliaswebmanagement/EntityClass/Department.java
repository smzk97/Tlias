package org.example.tliaswebmanagement.EntityClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;

/**
 * 部门信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int id; // 部门ID
    private String name; // 部门名称
    private LocalDateTime createTime; // 部门创建时间
    private LocalDateTime updateTime; // 部门修改时间
}
