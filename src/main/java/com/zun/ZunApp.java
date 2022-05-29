package com.zun;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

// url h2 консоли: http://localhost:8080/h2-console
// url базы: jdbc:h2:mem:testdb

@SpringBootApplication
public class ZunApp {


    public static void main(String[] args) {

        //Запуск SpringBoot-приложения и получение контекста
        ConfigurableApplicationContext context = SpringApplication.run(ZunApp.class, args);
//       context.getBean(LibDemoService.class).bookDemo();
//
      try {
           Console.main(args);
      } catch (SQLException e) {
            e.printStackTrace();
     }

    }
}
