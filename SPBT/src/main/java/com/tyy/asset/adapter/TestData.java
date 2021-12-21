package com.tyy.asset.adapter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fund_factor_data")
public class TestData {

    @Id
    String fundId;
    String factorId;
    String data;
    String createTime;

}
