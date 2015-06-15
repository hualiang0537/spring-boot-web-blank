package com.github.yingzhuo;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class SpringConfigDataSource {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.stat-filter")
    public Filter statFilter() {
        return new StatFilter();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.slf4j-log-filter")
    public Filter slf4jLogFilter() {
        return new Slf4jLogFilter();
    }

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setProxyFilters(Arrays.asList(
                statFilter(),
                slf4jLogFilter()
        ));
        return ds;
    }

}
