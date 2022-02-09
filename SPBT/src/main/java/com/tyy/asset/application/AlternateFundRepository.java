package com.tyy.asset.application;

import com.tyy.asset.adapter.AlternateFundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname AlternateFundRepository
 * @Date 2022/1/11 17:42
 * @Created by taoyuanyuan
 */
@Repository
public interface AlternateFundRepository extends JpaRepository<AlternateFundEntity,String> {

    List<AlternateFundEntity>getAllByUserId(String userId);

}
