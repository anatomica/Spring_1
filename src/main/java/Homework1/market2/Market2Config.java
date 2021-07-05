package Homework1.market2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"Homework1.market2"})
public class Market2Config {
    @Bean
    public String strBean() {
        return "strBean";
    }
}