package com.tyy.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean(name = "huaTaiStockDataSource")
    @ConfigurationProperties(prefix = "thirdparty.stock.datasource.hikari")
    DataSource huaTaiStockDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(huaTaiStockDataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate thirdPartyNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(huaTaiStockDataSource());
    }


}
