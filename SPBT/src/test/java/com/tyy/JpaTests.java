package com.tyy;

import com.tyy.jpa.output.entity.DashboardMapEntity;
import com.tyy.jpa.output.jpa.DashboardMapRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
class JpaTests {


    @Autowired
    DashboardMapRepository dashboardMapRepository;


    @Test
    void contextLoads() {
        List<DashboardMapEntity> all = dashboardMapRepository.findAll();
        System.out.println(all.size());
        Optional<DashboardMapEntity> byId = dashboardMapRepository.findById(new DashboardMapEntity.Key("111a", "CONFIGURE", "BAR_CHART_LAYOUT"));
        System.out.println(byId.isPresent());


        List<DashboardMapEntity> dashboardMapEntities = dashboardMapRepository.customizeQuery("tyytest");
        List<DashboardMapEntity> dashboardMapEntities2 = dashboardMapRepository.customizeQuery2("tyytest", new DashboardMapEntity.Key("111a", "CONFIGURE", "BAR_CHART_LAYOUT"));
        List<Map<String, String>> map = dashboardMapRepository.customizeQuery3("tyytest");
        List<DashboardMapEntity> dashboardMap = dashboardMapRepository.customizeQuery4("111a");
        System.out.println(dashboardMap);
        System.out.println(map);

        System.out.println(dashboardMapEntities.size());
        System.out.println(dashboardMapEntities2.size());
    }
}
