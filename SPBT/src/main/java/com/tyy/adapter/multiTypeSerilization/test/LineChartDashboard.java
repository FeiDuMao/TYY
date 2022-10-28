package com.tyy.adapter.multiTypeSerilization.test;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.List;

/**
 * @Date 2022/10/19 15:02
 * @Created by taoyuanyuan
 */

public class LineChartDashboard extends DashboardMapView {

    private String factorCode;
    private String queryTagCategoryCode;
    private SelectedTimeType selectedTimeType;
    private LocalDate from;
    private LocalDate to;
    private List<String> parentTag;

    @ConstructorProperties({"id", "layout", "factorCode", "queryTagCategoryCode", "selectedTimeType", "from", "to", "parentTag"})
    public LineChartDashboard(String id, String code, Layout layout, ModuleType moduleType, String factorCode, String queryTagCategoryCode, SelectedTimeType selectedTimeType, LocalDate from, LocalDate to, List<String> parentTag) {
        super(id, code, layout, moduleType);
        this.factorCode = factorCode;
        this.queryTagCategoryCode = queryTagCategoryCode;
        this.selectedTimeType = selectedTimeType;
        this.from = from;
        this.to = to;
        this.parentTag = parentTag;
    }

}
