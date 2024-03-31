package com.youzhan.demo;

import com.youzhan.controller.TaifexCtrl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.youzhan")
public class DemoApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		context.getBean(TaifexCtrl.class);

		System.out.println("Hello world!!!!!!!!!!!!!!!!!");

	}


}
