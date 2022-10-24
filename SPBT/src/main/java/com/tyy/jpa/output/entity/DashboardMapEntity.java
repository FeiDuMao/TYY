package com.tyy.jpa.output.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Date 2022/10/18 15:41
 * @Created by taoyuanyuan
 */

@Table(name = "dashboard_map")  //当数据库表名和className不一样时加此注解
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardMapEntity {

    @EmbeddedId
    private Key pk;

    private String factorCode;
    private String tagCategoryCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public DashboardMapEntity(Key pk, LocalDate startDate, LocalDate endDate) {
        this.pk = pk;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    @Embeddable
    @NoArgsConstructor    //主键Key必须有无参构造、必须实现序列化接口
    @AllArgsConstructor
    public static class Key implements Serializable {
        @Serial
        private static final long serialVersionUID = -6812608912843626610L;
        private String id;
        private String moduleType;
        private String layout;
    }


}
