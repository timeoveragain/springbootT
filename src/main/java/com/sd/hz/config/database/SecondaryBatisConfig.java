package com.sd.hz.config.database;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(basePackages = {"com.sd.hz.mapper.secondary"},sqlSessionFactoryRef = "secondarySqlSessionBean")
public class SecondaryBatisConfig {

    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource dataSource;

    @Bean(name = "secondarySqlSessionBean")
//    @ConditionalOnMissingBean //当容器里没有指定的Bean的情况下创建该对象
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mybatis的主配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource mybatisConfigXml = resolver.getResource("classpath:mapper/mysql/mybatis-config.xml");
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/secondary/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.sd.hz.po");

        return sqlSessionFactoryBean;
    }


    @Primary
    @Bean(name = "secondaryTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}
