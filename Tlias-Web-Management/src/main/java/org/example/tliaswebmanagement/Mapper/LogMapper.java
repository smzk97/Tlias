package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.tliaswebmanagement.EntityClass.OperateLog;

import java.util.List;

@Mapper
public interface LogMapper {
    void insertLogData(OperateLog operateLog);
    List<OperateLog> queryLogData(Integer page,Integer pageSize);
}
