package com.tyy.adapter.multiTypeSerilization.test;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

/**
 * @Date 2022/10/19 14:45
 * @Created by taoyuanyuan
 */
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(BarChartDashboard.class),
        @JsonSubTypes.Type(LineChartDashboard.class),
        @JsonSubTypes.Type(PositionDetailDashboard.class)
})
public abstract class DashboardMapView {

    private String id;
    private String code;
    private Layout layout;
    private ModuleType moduleType;

    protected DashboardMapView(String id, String code, Layout layout, ModuleType moduleType) {
        this.id = id;
        this.code = code;
        this.layout = layout;
        this.moduleType = moduleType;
    }


    public DashboardMapView setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
        return this;
    }

    public DashboardMapView setUserName(String userName) {
        this.code = userName;
        return this;
    }

}
