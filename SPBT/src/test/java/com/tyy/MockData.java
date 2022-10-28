package com.tyy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.NonNull;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@SpringBootTest
public class MockData {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Test
    @Transactional
    public void mockData2() {

        Map<String, String> result = new HashMap<>();

        String sql = "select * from stock_meta";

        List<Object> query = jdbcTemplate.query(sql, (row, index) -> {
            row.getString(1);
            row.getString(2);
            row.getString(3);
            return null;
        });


        jdbcTemplate.query(sql, (row) -> {
            row.getString(1);
            row.getString(2);
            row.getString(3);
        });

        result.forEach((k, v) -> System.out.println(k + "  " + v));
    }


    @Test
    public void mockData() throws SQLException {


        String sql = "insert into huatai_stock.factor_exposures_by_date(primary_id,id,trading_date,stock_code,value) values(?,?,?,?,?) ";
//        Connection connection = jdbcTemplate.getDataSource().getConnection();

        LocalDate now = LocalDate.now();
        List<StockClosePrice> data = IntStream.range(0, 1000).boxed().map(i -> new StockClosePrice("close_price", now, i.toString(), i.doubleValue())).toList();
        jdbcTemplate.batchUpdate(
                "insert into huatai_stock.factor_exposures_by_date(id,trading_date,stock_code,value) values(?,?,?,?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(@NonNull PreparedStatement ps, int i) throws SQLException {
                        StockClosePrice stockClosePrice = data.get(i);
                        ps.setString(1, stockClosePrice.id);
                        ps.setObject(2, stockClosePrice.tradingDate);
                        ps.setString(3, stockClosePrice.stockCode);
                        ps.setDouble(4, stockClosePrice.value);
                    }

                    @Override
                    public int getBatchSize() {
                        return data.size();
                    }
                });
        jdbcTemplate.query(
                "select * from huatai_stock.factor_exposures_by_date",
                rs -> {
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                }
        );


    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class StockClosePrice {

        String id;
        LocalDate tradingDate;
        String stockCode;
        Double value;


    }
}
