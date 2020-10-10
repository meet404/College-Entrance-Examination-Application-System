package com.wzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wzq
 * @date 2020/10/2
 * @email 158957716@qq.com
 */
@MapperScan("com.wzq.mapper")
@EnableTransactionManagement
@SpringBootApplication
@EnableAsync
public class TcDemo01Application {

	public static void main(String[] args) {
		SpringApplication.run(TcDemo01Application.class, args);
	}

}
