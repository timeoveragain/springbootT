package com.sd.hz.config.database;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

//@Configuration
//@AutoConfigureAfter(MyBatisConfig.class) //保证在MyBatisConfig实例化之后再实例化该类
public class MapperScannerConfig {

    // mapper接口的扫描器
//    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.sd.hz.mapper.primary");
        return mapperScannerConfigurer;
    }


}
