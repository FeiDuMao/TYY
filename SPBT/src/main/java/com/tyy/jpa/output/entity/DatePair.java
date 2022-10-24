package com.tyy.jpa.output.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Date 2022/10/24 17:15
 * @Created by taoyuanyuan
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatePair {

    LocalDate start;
    LocalDate end;

    public DatePair(DashboardMapEntity dashboardMap) {
        this.start = dashboardMap.getStartDate();
        this.end = dashboardMap.getEndDate();
    }
}
