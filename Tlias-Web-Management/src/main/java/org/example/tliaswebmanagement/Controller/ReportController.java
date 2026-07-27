package org.example.tliaswebmanagement.Controller;

import com.sun.net.httpserver.Authenticator;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.JobDataResult;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    private ReportService reportService;
    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    /**
     * 处理查询职位统计的查询
     * @return 成功结果对象
     */
    @GetMapping("/empJobData")
    public Result JobData(){
        JobDataResult jobDataResult = reportService.JobData();
        return Result.Success(jobDataResult);
    }

    @GetMapping("/empGenderData")
    public Result GenderData(){
        List<Map<String,Object>> genderData = reportService.GenderData();
        return Result.Success(genderData);
    }
}
