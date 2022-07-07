package com.sinosoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/9/14 15:17
 */
@SpringBootApplication
@MapperScan("com.sinosoft.dao")
@EnableCaching
@EnableScheduling
@EnableTransactionManagement
public class ReptileApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReptileApplication.class, args);
    }
}
