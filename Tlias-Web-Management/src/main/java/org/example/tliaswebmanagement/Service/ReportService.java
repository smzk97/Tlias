package org.example.tliaswebmanagement.Service;

import org.example.tliaswebmanagement.EntityClass.JobDataResult;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobDataResult JobData();
    List<Map<String,Object>> GenderData();
}
