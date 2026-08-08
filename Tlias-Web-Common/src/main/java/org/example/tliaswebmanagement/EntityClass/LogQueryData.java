package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

// 查询日志对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogQueryData {
    private long total;                    // 查询返回总数
    private List<OperateLog> rows;       // 查询返回的数据
}
