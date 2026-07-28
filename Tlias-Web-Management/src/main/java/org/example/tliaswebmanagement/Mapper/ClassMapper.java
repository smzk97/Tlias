package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.Class;
import org.example.tliaswebmanagement.EntityClass.ClassQueryParam;

import java.util.List;

@Mapper
public interface ClassMapper {
    /**
     * 查询班级列表数据
     * @param classQueryParam 查询参数对象
     * @return
     */
    List<Class> findAll(ClassQueryParam classQueryParam);
}
