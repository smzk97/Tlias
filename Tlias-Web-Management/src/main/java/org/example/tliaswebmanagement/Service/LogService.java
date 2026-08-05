package org.example.tliaswebmanagement.Service;

import org.example.tliaswebmanagement.EntityClass.LogQueryData;
import java.util.List;

public interface LogService {
    LogQueryData queryLogData(Integer page, Integer pageSize);
}
