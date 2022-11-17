package com.tyy;

import com.tyy.jpa.converter.DashboardEntity;
import com.tyy.jpa.converter.DashboardRepository;
import com.tyy.jpa.converter.ParentTag;
import com.tyy.jpa.output.entity.DashboardMapEntity;
import com.tyy.jpa.output.jpa.DashboardMapRepository;
import com.tyy.jpa.person.PersonEntity;
import com.tyy.jpa.person.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
class JpaTests {


    @Autowired
    DashboardMapRepository dashboardMapRepository;

    @Autowired
    DashboardRepository dashboardRepository;

    @Autowired
    PersonRepository personRepository;


    @Test
    void testUpdate() {
        PersonEntity person = PersonEntity.builder()
                .name("tyy")
                .age(10)
                .phoneNum("12345").build();
        PersonEntity saved = personRepository.saveAndFlush(person);

//        personRepository.updateStatus(11,3);
//        personRepository.updateStatus(11,1);
//        System.out.println(saved);

        System.out.println("111");
    }


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

    @Test
    void converter_test() {
        final DashboardEntity en = new DashboardEntity("333", List.of(new ParentTag("2", "c2"), new ParentTag("1", "c1")));
        DashboardEntity save = dashboardRepository.save(en);
        Assertions.assertEquals(en, save);
    }
}
