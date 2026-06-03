package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWorkExperience {
    private Integer id;
    private Integer employeeId;
    private LocalDate startTime;
    private LocalDate endTime;
    private String company;
    private String job;
}
