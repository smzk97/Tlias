package org.example.tliaswebmanagement.Service.Ipl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.EntityClass.Class;
import org.example.tliaswebmanagement.EntityClass.ClassQueryData;
import org.example.tliaswebmanagement.EntityClass.ClassQueryParam;
import org.example.tliaswebmanagement.Mapper.ClassMapper;
import org.example.tliaswebmanagement.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClassServiceIpl implements ClassService {
    private ClassMapper classMapper;
    @Autowired
    public ClassServiceIpl(ClassMapper classMapper){
        this.classMapper = classMapper;
    }

    @Override
    public ClassQueryData findAll(ClassQueryParam classQueryParam){
        PageHelper.startPage(classQueryParam.getPage(),classQueryParam.getPageSize());
        List<Class> classListData = classMapper.findAll(classQueryParam);
        Page<Class> pageData = (Page<Class>) classListData;
        return new ClassQueryData(pageData.getTotal(),pageData.getResult());
    }
}
