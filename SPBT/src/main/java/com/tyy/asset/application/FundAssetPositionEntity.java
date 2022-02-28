package com.tyy.asset.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "fund_asset_position")
@IdClass(value = FundAssetPositionEntity.FundAssetPositionEntityKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundAssetPositionEntity {
    /** fundId */
    @Id
    private String fundId;
    /** 报告日 */
    @Id
    private String reportDate;
    /** 披露日 */
    private LocalDate releaseDate;

    /** 资产总值 */
    private Double totalasset;
    /** 资产净值 */
    private Double netasset;

    /** 股票 */
    private Double stockvalue;
    /** 股票占资产净值比例 */
    private Double stocktonav;
    /** 股票占资产总值比例 */
    private Double stocktotot;
    /** 股票比例较上期变化 */
    private Double stocktonavchange;

    /** 指数投资持有股票市值 */
    private Double pasvstkvalue;
    private Double pasvstktonav;

    /** 积极投资持有股票市值 */
    private Double posvstkvalue;
    private Double posvstktonav;

    /** 国债 */
    private Double govbond;
    private Double govbondtonav;

    /** 现金 */
    private Double cash;
    private Double cashtonav;
    private Double cashtotot;
    private Double cashtonavchange;

    /** 国债及现金 */
    private Double govcashvalue;
    private Double govcashtonav;

    /** 持有债券市值(不含国债) */
    private Double bdvalueNogov;
    private Double bdtonavNogov;

    /** 金融债 */
    private Double finanbond;
    private Double finanbondtonav;

    /** 可转债 */
    private Double covertbond;
    private Double covertbondtonav;

    /** 企债 */
    private Double corpbond;
    private Double corpbondtonav;

    /** 债券 */
    private Double bondvalue;
    private Double bondtonav;
    private Double bondtotot;
    private Double bondtonavchange;

    /** 央行票据 */
    private Double ctrbankbill;
    private Double ctrbankbilltonav;

    /** 权证 */
    private Double warrantvalue;
    private Double warrantonav;
    private Double warrantotot;

    /** 资产支持证券 */
    private Double absvalue;
    private Double absvaluetonav;

    /** 政策性金融债 */
    private Double polifinanbdvalue;
    private Double polifinanbdtonav;

    /** 基金 */
    private Double fundvalue;
    private Double fundtonav;
    private Double fundtotot;

    /** 货币市场工具 */
    private Double mmvalue;
    private Double mmtonav;
    private Double mmtotot;

    /** 其他资产 */
    private Double other;
    private Double othertonav;
    private Double othertotot;
    private Double othertototchange;

    /** 借贷方差额 */
    private Double debcrebalance;

    /** 投资组合平均剩余期限 */
    private Double avgptm;

    /** 买入返售证券 */
    private Double reverserepo;
    private Double reverserepotonav;
    private Double reverserepototot;
    /** 卖出回购证券 */
    private Double repo;

    /** 短期融资券 */
    private Double cpvalue;
    /** 中期票据 */
    private Double mtnvalue;
    /** 同业存单 */
    private Double cds;
    /** 港股通投资港股 */
    private Double hkstockvalue;
    private Double hkstocktonav;

    /** 其他债券 */
    private Double othBdvalue;

    public FundAssetPositionEntity(String reportDate, Double netasset) {
        this.reportDate = reportDate;
        this.netasset = netasset;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FundAssetPositionEntityKey implements Serializable {
        private static final long serialVersionUID = 3628743080934453539L;
        private String fundId;
        private String reportDate;
    }


}
