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

    /**
     * 根据ID值删除指定班级列表数据
     * @param id 班级数据主键
     */
    void deleteById(Integer id);

    /**
     * 根据传递的Class对象新增班级列表数据
     * @param classData 新增的数据封装为Class对象
     */
    void insertData(Class classData);

    /**
     * 根据传递的Class对象更新班级列表数据
     * @param classData 更新的数据封装为Class对象
     */
    void updateData(Class classData);
}
