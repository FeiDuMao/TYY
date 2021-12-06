package com.tyy.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class generator {

    @Test
    public  void test() {
        AutoGenerator mpg=new AutoGenerator();

        //数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8");
        dsc.setDbType(DbType.MYSQL);
        dsc.setUsername("root");
        dsc.setPassword("624957381");
        mpg.setDataSource(dsc);

        //包设置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.tyy");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);

        //策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("loginuser");
        sc.setNaming(NamingStrategy.no_change);
        sc.setColumnNaming(NamingStrategy.no_change);
        sc.setEntityLombokModel(true);
        mpg.setStrategy(sc);


        //全局配置
        GlobalConfig gc=new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("tyy");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setSwagger2(true);
        gc.setServiceName("");
        mpg.setGlobalConfig(gc);


        mpg.execute();

    }
}
