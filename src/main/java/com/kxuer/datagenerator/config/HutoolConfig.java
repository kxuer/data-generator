package com.kxuer.datagenerator.config;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HutoolConfig {
    //雪花算法生成工具类
    @Bean
    public SnowflakeGenerator snowflakeGenerator() {
        return new SnowflakeGenerator(0, 0);
    }
}
