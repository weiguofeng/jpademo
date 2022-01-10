package com.llbt.jpademo;

import com.llbt.jpademo.base.BaseRepositoryFactoryBean;
import com.llbt.jpademo.base.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
//@ComponentScan(basePackages = "com.ll")//扫描 @Controller、@Service 注解；
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class JpademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpademoApplication.class, args);
    }


}
