package com.tyy.adapter.multiTypeSerilization.test;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.List;

/**
 * @Date 2022/10/19 15:08
 * @Created by taoyuanyuan
 */
public class PositionDetailDashboard extends DashboardMapView {

    private String tagCategoryCode;
    private LocalDate date;
    private List<String> factorCodes;

    @ConstructorProperties({"id", "layout", "tagCategoryCode", "date", "factorCodes"})
    public PositionDetailDashboard(String id, String code, Layout layout, ModuleType moduleType, String tagCategoryCode, LocalDate date, List<String> factorCodes) {
        super(id, code, layout, moduleType);
        this.tagCategoryCode = tagCategoryCode;
        this.date = date;
        this.factorCodes = factorCodes;
    }


}
