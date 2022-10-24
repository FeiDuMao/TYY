package com.tyy.jpa.output.jpa;

import com.tyy.jpa.output.entity.DashboardMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @Date 2022/10/19 14:46
 * @Created by taoyuanyuan
 */
public interface DashboardMapRepository extends JpaRepository<DashboardMapEntity, DashboardMapEntity.Key> {


    /**
     * 1.如果只需要指定的参数，则需要重载一个指定参数的构造器
     * 2.可以自定义参数入参名称，:xxx 然后使用@Param注解
     */
    @Query("select new DashboardMapEntity(pk,startDate,endDate) from DashboardMapEntity where factorCode= :custCode")
    List<DashboardMapEntity> customizeQuery(@Param("custCode") String code);


    /**
     * 按照入参顺序进行查询
     */
    @Query("select new DashboardMapEntity(pk,startDate,endDate) from DashboardMapEntity where  factorCode = ?1 and pk= ?2")
    List<DashboardMapEntity> customizeQuery2(String code, DashboardMapEntity.Key pk);


    /**
     * 只选取需要的列，以List<Map>的方式进行返回
     * as xxx 对应Map中的Key
     */
    @Query("select startDate as start,endDate as end from DashboardMapEntity where  factorCode = ?1")
    List<Map<String, String>> customizeQuery3(String code);

    /**
     * 只根据主键的一部分进行查询
     */
    @Query("select new DashboardMapEntity(pk,startDate,endDate) from DashboardMapEntity where  pk.id = ?1")
    List<DashboardMapEntity> customizeQuery4(String code);


}
