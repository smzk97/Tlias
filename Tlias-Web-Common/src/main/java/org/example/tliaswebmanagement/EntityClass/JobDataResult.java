package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

// 职位统计

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDataResult {
    private List<Object> jobList;
    private List<Object> dataList;
}
