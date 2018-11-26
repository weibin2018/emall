package com.emall.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName Application
 * @Description 服务注册中心启动类
 * @Author weibin
 * @Date 2018/11/26 21:35
 * @Version 1.0
 **/
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class,DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
