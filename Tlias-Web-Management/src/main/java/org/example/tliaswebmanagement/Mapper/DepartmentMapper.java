package org.example.tliaswebmanagement.Mapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.Department;
import java.util.List;

/**
 * 关于部门表的Crud接口管理
 */
@Mapper
public interface DepartmentMapper {

    /**
     * 查询部门表的所有信息
     * @return 部门列表信息的集合
     */
    List<Department> findAll();

    /**
     * 根据id值删除某条部门信息
     * @param id 部门ID值
     */
    void deleteById(Integer id);

    /**
     * 根据name新增部门信息
     * @param department Department对象
     */
    void insertByName(Department department);

    /**
     * 根据id查询部门信息
     * @param id 部门ID
     * @return Department对象
     */
    List<Department> queryById(Integer id);

    /**
     * 新增部门数据
     * @param department Department对象
     */
    void Update(Department department);
}
