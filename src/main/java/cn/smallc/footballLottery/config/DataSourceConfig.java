package cn.smallc.footballLottery.config;

import cn.smallc.footballLottery.properties.DruidDataSourceProperties;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

	@Autowired
	private DataSourceProperties dataSourceProperties;

	@Autowired
	private DruidDataSourceProperties druidDataSourceProperties;

	@Primary
	// 默认数据源
	@Bean(name = "dataSource", destroyMethod = "close")
	public DruidDataSource Construction() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		dataSource.setPassword(dataSourceProperties.getPassword());
		dataSource
				.setDriverClassName(dataSourceProperties.getDriverClassName());
	
		// 配置最大连接
		dataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
		// 配置初始连接
		dataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
		// 配置最小连接
		dataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
		// 连接等待超时时间
		dataSource.setMaxWait(druidDataSourceProperties.getMaxWait());
		// 间隔多久进行检测,关闭空闲连接
		dataSource.setTimeBetweenEvictionRunsMillis(druidDataSourceProperties
				.getTimeBetweenEvictionRunsMillis());
		// 一个连接最小生存时间
		dataSource.setMinEvictableIdleTimeMillis(druidDataSourceProperties
				.getMinEvictableIdleTimeMillis());
		// 用来检测是否有效的sql
		dataSource.setValidationQuery(druidDataSourceProperties
				.getValidationQuery());
		dataSource
				.setTestWhileIdle(druidDataSourceProperties.isTestWhileIdle());
		dataSource.setTestOnBorrow(druidDataSourceProperties.isTestOnBorrow());
		dataSource.setTestOnReturn(druidDataSourceProperties.isTestOnReturn());
		// 打开PSCache,并指定每个连接的PSCache大小
		dataSource.setPoolPreparedStatements(druidDataSourceProperties
				.isPoolPreparedStatements());
		dataSource.setMaxOpenPreparedStatements(druidDataSourceProperties
				.getMaxOpenPreparedStatements());
		// 配置sql监控的filter
		dataSource.setFilters(druidDataSourceProperties.getFilters());
		
		
		
		dataSource.setRemoveAbandoned(druidDataSourceProperties
				.isRemoveAbandoned());
		dataSource.setRemoveAbandonedTimeoutMillis(druidDataSourceProperties
				.getRemoveAbandonedTimeoutMillis());
		dataSource.setLogAbandoned(druidDataSourceProperties.isLogAbandoned());
		
		try {
			dataSource.init();
		} catch (SQLException e) {
			throw new RuntimeException("druid datasource init fail");
		}
		return dataSource;
	}

	/**
	 * druid监控
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings("/druid/*");
		// reg.addInitParameter("allow", "127.0.0.1");
		// reg.addInitParameter("deny","");
		reg.addInitParameter("loginUsername", "admin");
		reg.addInitParameter("loginPassword", "admin");
		return reg;
	}

	/**
	 * druid监控过滤
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions",
				"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
