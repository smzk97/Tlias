package org.example.tliaswebmanagement.Service.Ipl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.EntityClass.LogQueryData;
import org.example.tliaswebmanagement.EntityClass.OperateLog;
import org.example.tliaswebmanagement.Mapper.LogMapper;
import org.example.tliaswebmanagement.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogSeriviceIpl implements LogService {

    private LogMapper logMapper;
    @Autowired
    public LogSeriviceIpl(LogMapper logMapper){
        this.logMapper = logMapper;
    }

    @Override
    public LogQueryData queryLogData(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OperateLog> operateLogs = logMapper.queryLogData(page,pageSize);
        Page<OperateLog> pageLogs = (Page<OperateLog>) operateLogs;
        return new LogQueryData(pageLogs.getTotal(),pageLogs.getResult());
    }
}
