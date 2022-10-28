package com.tyy.adapter.multiTypeSerilization;

import com.tyy.adapter.multiTypeSerilization.test.DashboardMapView;
import com.tyy.adapter.multiTypeSerilization.test.ModuleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListBaseReq {


    List<DashboardMapView> requests;

    ModuleType moduleType;

}
