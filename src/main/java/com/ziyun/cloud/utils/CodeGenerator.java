package com.ziyun.cloud.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.ziyun.cloud.constant.BaseException;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:cxy
 * @Date:2018/11/27 18:16
 */
public class CodeGenerator {


    public static void main(String[] args) {

        Configuration config = getConfig();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = config.getString("projectPath");
            //F:\\dev\\IDEAworkspace2\\boot-module\\boot-generator
        gc.setOutputDir(projectPath  +"/src/main/java");
        gc.setAuthor(config.getString("author"));
        gc.setOpen(false);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(config.getString("dateSourceUrl"));
            // dsc.setSchemaName("public");
        dsc.setDriverName(config.getString("driverName"));
        dsc.setUsername(config.getString("username"));
        dsc.setPassword(config.getString("password"));
            // 自动类型转换 可自定义 processTypeConvert 存在默认类型转换 入需要修改则重写
        dsc.setTypeConvert(new SqlTypeConvert());
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
            //moduleName=goods
        pc.setModuleName(config.getString("moduleName"));//模块名
            //parentPackage = com.service.product
        pc.setParent(config.getString("parentPackage"));//父类包
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath  +"/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null).setController(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(config.getString("tableName"));
        strategy.setSuperEntityColumns("id");
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    /**
     * 获取配置信息
     */
    public static Configuration getConfig(){
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new BaseException("获取配置文件失败");
        }
    }

//
//    @Test
//    public void  testGenerator() {
//        //1. 全局配置
//        GlobalConfig config = new GlobalConfig();
//        config.setActiveRecord(true) // 是否支持AR模式
//                .setAuthor("") // 作者
//                .setOutputDir("D:\\workspace_mp\\mp03\\src\\main\\java") // 生成路径
//                .setFileOverride(true)  // 文件覆盖
//                .setIdType(IdType.AUTO) // 主键策略
//                .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
//                // IEmployeeService
//                .setBaseResultMap(true)
//                .setBaseColumnList(true);
//
//        //2. 数据源配置
//        DataSourceConfig  dsConfig  = new DataSourceConfig();
//        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
//                .setDriverName("com.mysql.jdbc.Driver")
//                .setUrl("jdbc:mysql://47.99.42.43:3306/ziyun_service_soa?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false")
//                .setUsername("ziyun")
//                .setPassword("ziyun101");
//
//        //3. 策略配置
//        StrategyConfig stConfig = new StrategyConfig();
//        stConfig.setCapitalMode(true) //全局大写命名
//                .setExclude("controller")
//                .setRestControllerStyle(false)
//                //.setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
//                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
//                .setInclude("goods_category");  // 生成的表
//
//        //4. 包名策略配置
//        PackageConfig pkConfig = new PackageConfig();
//        pkConfig.setParent("com.ziyun.category")
//                .setMapper("mapper")
//                .setService("service")
//                .setEntity("beans")
//                .setXml("mapper");
//
//        //5. 整合配置
//        AutoGenerator  ag = new AutoGenerator();
//
//        ag.setGlobalConfig(config)
//                .setDataSource(dsConfig)
//                .setStrategy(stConfig)
//                .setPackageInfo(pkConfig);
//
//        //6. 执行
//        ag.execute();
//    }

}
