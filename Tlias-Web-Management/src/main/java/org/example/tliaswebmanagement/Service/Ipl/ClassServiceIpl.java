package org.example.tliaswebmanagement.Service.Ipl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Class;
import org.example.tliaswebmanagement.EntityClass.ClassQueryData;
import org.example.tliaswebmanagement.EntityClass.ClassQueryParam;
import org.example.tliaswebmanagement.Mapper.ClassMapper;
import org.example.tliaswebmanagement.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ClassServiceIpl implements ClassService {
    private ClassMapper classMapper;
    @Autowired
    public ClassServiceIpl(ClassMapper classMapper){
        this.classMapper = classMapper;
    }

    @Override
    public ClassQueryData findAllByPage(ClassQueryParam classQueryParam){
        PageHelper.startPage(classQueryParam.getPage(),classQueryParam.getPageSize());
        List<Class> classListData = classMapper.findAllByPage(classQueryParam);
        Page<Class> pageData = (Page<Class>) classListData;
        return new ClassQueryData(pageData.getTotal(),pageData.getResult());
    }

    @Override
    public List<Class> findAll() {
        List<Class> classListData = classMapper.findAll();
        return classListData;
    }

    @Override
    public Class findById(Integer id) {
        Class classData = classMapper.findById(id);
        return classData;
    }

    @Override
    public void deleteById(Integer id) {
        classMapper.deleteById(id);
        log.info("成功删除主键为 {id} 的班级数据");
    }

    @Override
    public void insertData(Class classData) {
        log.info("成功新增班级数据");
        classData.setCreateTime(LocalDateTime.now());
        classData.setUpdateTime(LocalDateTime.now());
        classMapper.insertData(classData);
    }

    @Override
    public void updateDate(Class classData) {
        log.info("成功更改主键为 {classData.getId()} 的班级数据");
        classData.setUpdateTime(LocalDateTime.now());
        classMapper.updateData(classData);
    }
}
