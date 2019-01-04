package com.emall.user;

import com.emall.core.spring.SpringContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName Application
 * @Description 用户服务启动
 * @Author weibin
 * @Date 2018/12/7 14:29
 * @Version 1.0
 **/
@SpringBootApplication(scanBasePackages = "com.emall.*",exclude = HibernateJpaAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan("com.emall.user.mapper")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        SpringContext.setContext(context);
    }
}
