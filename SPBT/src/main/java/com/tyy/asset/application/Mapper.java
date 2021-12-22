package com.tyy.asset.application;



import com.tyy.asset.adapter.TestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

//@org.apache.ibatis.annotations.Mapper
@Repository
public interface Mapper extends JpaRepository<TestData,List<String>>, JpaSpecificationExecutor<TestData> {

//    @Select("select * from fund_factor_data where fund_id in (#{fundIds}) and factor_id in (#{factorIds})")
//    public List<Data> get(@Param("fundIds") List<String>fundIds, @Param("factorIds") List<String>factorIds);
//
//
//    @Select("select fund_id fundId, factor_id factorId,data ,create_time createTime from fund_factor_data where fund_id =#{fundId}")
//    public List<Data> get2(@Param("fundId") String fundId);

    @Query(value = "select * from fund_factor_data where fund_id in (?1) and factor_id in (?2)",nativeQuery = true)
    public List<TestData> getAllByFundIdAndFactorId(String fundIds, String factorIds);


    @Query(value = "select * from fund_factor_data where fund_id in (:ids)",nativeQuery = true)
    List<TestData>getAllByFundId(@Param("ids") List<String> fundIds);

    @Query(value = "select * from fund_factor_data where factor_id in (?1)",nativeQuery = true)
    List<TestData>getAllByFactorId(String factorIds);





}
