
package com.ziyun.cloud.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 
 * @author Zhang.Peng
 * @date 2018年9月14日下午6:27:54
 */
// @MapperScan(basePackages = { "com.service.db.mapper" })
// @MapperScan(basePackages = { "com.service.ucenter.dao.mapper" })
@Configuration
@EnableTransactionManagement(order = 2)
public class MybatisPlusConfig {

	@Bean
	public PaginationInterceptor getPaginationInterceptor() {
		PaginationInterceptor page = new PaginationInterceptor();
		page.setDialectType("mysql");
		return page;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ResourceLoader resourceLoader) throws Exception {
		MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
		MybatisConfiguration configuration = new MybatisConfiguration();
		configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		//*注册Map 下划线转驼峰*/
		configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());

		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setConfiguration(configuration);
		PaginationInterceptor bean = getPaginationInterceptor();
		sqlSessionFactory.setPlugins(new PaginationInterceptor[] {bean});
		// ...其他配置
		return sqlSessionFactory.getObject();
	}

	@Bean
	public ISqlInjector getISqlInjector() {
		return new DefaultSqlInjector();
	}

	/**
	 * SQL执行效率插件
	 */
	@Bean
	public PerformanceInterceptor performanceInterceptor() {
		return new PerformanceInterceptor();
	}

}
