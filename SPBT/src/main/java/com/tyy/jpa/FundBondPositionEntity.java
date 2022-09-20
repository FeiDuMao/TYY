package com.tyy.jpa;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Date 2022/9/20 15:30
 * @Created by taoyuanyuan
 */
@Table(name = "fund_bond_position")//当entity与数据库表名不一致时使用此注解
@Entity
@IdClass(FundBondPositionEntity.Key.class)
@NoArgsConstructor//一定要有一个无参构造器
public class FundBondPositionEntity {


    @Id
    private String fundCode;
    private String fundName;
    @Id
    private String bondCode;
    private String bondName;
    private Double percent;
    private LocalDate endDate;

    @NoArgsConstructor//IdClass 一定要有一个无参构造器！
    public static class Key implements Serializable {//IdClass 必须要实现Serializable
        @Serial
        private static final long serialVersionUID = -4548080049986726520L;
        private String fundCode;
        private String bondCode;
    }


}
