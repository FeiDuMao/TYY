package com.tyy.adapter.multiTypeSerilization.test;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.List;

/**
 * @Date 2022/10/19 15:06
 * @Created by taoyuanyuan
 */

public class BarChartDashboard extends DashboardMapView {

    private String factorCode;
    private String queryTagCategoryCode;
    private LocalDate date;
    private List<String> parentTag;

    //    @JsonCreator
    @ConstructorProperties({"id", "layout", "factorCode", "queryTagCategoryCode", "date", "parentTag"})
    public BarChartDashboard(String id,
                             String code,
                             Layout layout,
                             ModuleType moduleType,
                             String factorCode,
                             String queryTagCategoryCode,
                             LocalDate date,
                             List<String> parentTag) {
        super(id, code, layout, moduleType);
        this.factorCode = factorCode;
        this.queryTagCategoryCode = queryTagCategoryCode;
        this.date = date;
        this.parentTag = parentTag;
    }


}
