package top.study01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.study01.mapper")
public class Study01Application {

    public static void main(String[] args) {
        SpringApplication.run(Study01Application.class, args);
    }

}
