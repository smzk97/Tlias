package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 关于数据统计接口的管理
 */

@Mapper
public interface ReportMapper {
    /**
     * 查询职位统计数据
     * @return map列表
     */
    List<Map<String,Object>> JobData();

    /**
     * 查询性别统计数据
     * @return map列表
     */
    List<Map<String,Object>> GenderData();

    /**
     * 查询学员学历统计数据
     * @return map列表
     */
    List<Map<String,Integer>> DegreeData();
}
