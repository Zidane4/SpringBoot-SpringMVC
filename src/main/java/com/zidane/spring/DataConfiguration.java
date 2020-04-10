package com.zidane.spring;

import com.alibaba.druid.pool.DruidDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 事务配置类
 *
 * 用注解配置事务的方法，首先在启动类配置EnableTransactionManagement，然后再具体的方法上配置Transactional，但是要手动配置隔离级别，回滚方式等。
 * @EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
 * @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
 *
 * 还可以用xml配置的方式进行处理，本系统用xml方式，这样可以一次性对所有的方法做具体的配置。
 *
 * @author Zidane
 * @since 2018-04-08
 */
@Configuration
public class DataConfiguration {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapping/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
}