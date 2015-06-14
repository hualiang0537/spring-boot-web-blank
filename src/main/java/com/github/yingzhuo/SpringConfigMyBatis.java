package com.github.yingzhuo;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class SpringConfigMyBatis {

    @Resource
    private DataSource dataSource;

    @Bean
    @ConfigurationProperties(prefix = "spring.mybatis")
    public SqlSessionFactoryBean sqlSessionFactory() throws Throwable {
        final SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Throwable {
        SqlSessionTemplate template =
                new SqlSessionTemplate(sqlSessionFactory().getObject(), ExecutorType.SIMPLE, new MyBatisExceptionTranslator(dataSource, false));
        return template;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
