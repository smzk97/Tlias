package org.example.tliaswebmanagement.Service.Ipl;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.EntityClass.ClassStudentCountResult;
import org.example.tliaswebmanagement.EntityClass.JobDataResult;
import org.example.tliaswebmanagement.Mapper.ReportMapper;
import org.example.tliaswebmanagement.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceIpl implements ReportService {

    private ReportMapper reportMapper;
    @Autowired
    public ReportServiceIpl(ReportMapper reportMapper){
        this.reportMapper = reportMapper;
    }
    public JobDataResult JobData(){
        List<Map<String,Object>> jobData = reportMapper.JobData();
        List<Object> jobList = jobData.stream().map(job -> job.get("job")).toList();
        List<Object> dataList = jobData.stream().map(data -> data.get("num")).toList();
        return new JobDataResult(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> GenderData() {
        return reportMapper.GenderData();
    }

    @Override
    public List<Map<String, Integer>> DegreeData() {
        return reportMapper.DegreeData();
    }

    @Override
    public ClassStudentCountResult ClassStudentData() {
        List<Map<String,Object>> studentCount = reportMapper.ClassStudentData();
        List<Object> classList = studentCount.stream().map(stu -> stu.get("name")).toList();
        List<Object> dataList = studentCount.stream().map(stu -> stu.get("num")).toList();
        return new ClassStudentCountResult(classList, dataList);
    }
}
