package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Integer gender;
    private String name;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private String beginTime;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private String endTime;
}
