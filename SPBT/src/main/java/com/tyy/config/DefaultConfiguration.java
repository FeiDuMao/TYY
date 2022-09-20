package com.tyy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2022/9/20 15:52
 * @Created by taoyuanyuan
 */

@Data
@Configuration
@ConfigurationProperties("thread.pool")
public class DefaultConfiguration {

    /**
     * 属性名字与配置文件中的名字相同才行
     * ConfigurationProperties("thread.pool") + filedName = @Value("${thread.pool.core}")
     */

    private Integer core;
    private Integer max;
    private Integer queue;


}
