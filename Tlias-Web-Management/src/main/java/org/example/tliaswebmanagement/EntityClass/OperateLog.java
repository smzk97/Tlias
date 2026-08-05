package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

// 操作日志对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    private Integer id;                  // id
    private Integer operateEmpId;        // 操作人id
    private LocalDateTime operateTime;   // 操作时间
    private String className;            // 操作的类名
    private String methodName;           // 操作的方法名
    private String methodParams;         // 方法参数
    private String returnValue;          // 返回值
    private Long costTime;               // 方法执行耗时
    private String name;                 // 用户名
}
