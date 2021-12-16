package com.tyy.asset.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @Classname AlternateFundEntity
 * @Date 2022/1/11 17:14
 * @Created by taoyuanyuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fund_alternate_info")
public class AlternateFundEntity implements Serializable {

    private static final long serialVersionUID = 3129885012041206690L;

    @Id
    private String id;
    private String userId;
    private String targetFundId;
    private String tagId;
    private String alternateFundIds;
    private String code;
    private String name;
    private String description;
    private LocalDate saveDate;
    //来源：投顾，或者投研
    private String source;


}
