package com.tyy.asset.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface FundAssetPositionRepository
        extends JpaRepository<FundAssetPositionEntity, FundAssetPositionEntity.FundAssetPositionEntityKey> {

    @Query(value = "select new FundAssetPositionEntity (reportDate,netasset) FROM  FundAssetPositionEntity where fundId=?1")
    List<FundAssetPositionEntity> getNetAsset(String fundId);
}
