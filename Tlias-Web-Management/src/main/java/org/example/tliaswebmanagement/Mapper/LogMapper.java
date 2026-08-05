package org.example.tliaswebmanagement.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.OperateLog;

@Mapper
public interface LogMapper {
    void insertLogData(OperateLog operateLog);
}
