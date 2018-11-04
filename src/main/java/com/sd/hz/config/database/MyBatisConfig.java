package com.sd.hz.config.database;

//@Configuration
//@MapperScan
public class MyBatisConfig {

  /*  @Autowired
    @Qualifier("primaryDataSource")
    private DataSource dataSource;

    @Bean
    @ConditionalOnMissingBean //当容器里没有指定的Bean的情况下创建该对象
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mybatis的主配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource mybatisConfigXml = resolver.getResource("classpath:mapper/mysql/mybatis-config.xml");
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/mysql/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.sd.hz.po");

        return sqlSessionFactoryBean;
    }*/

}
