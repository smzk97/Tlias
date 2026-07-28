package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.Class;
import org.example.tliaswebmanagement.EntityClass.ClassQueryParam;

import java.util.List;

@Mapper
public interface ClassMapper {
    /**
     * 分页查询班级列表数据
     * @param classQueryParam 查询参数对象
     * @return 班级数据对象列表
     */
    List<Class> findAllByPage(ClassQueryParam classQueryParam);

    /**
     * 查询所有班级列表数据
     * @return 班级数据对象列表
     */
    List<Class> findAll();

    /**
     * 根据ID值查询班级列表数据
     * @param id 班级数据主键
     * @return 班级数据对象
     */
    Class findById(Integer id);
}
