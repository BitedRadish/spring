package myspring.di.xml.config;


import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:values.properties")public class HelloConfig {
    @Autowired
    private Environment env;

    @Bean
    public Printer stringPrinter(){
        return new StringPrinter();
    }

    @Bean
    public Printer consolePrinter(){
        return new ConsolePrinter();
    }

    @Bean
    public Hello hello(){
        Hello hello=new Hello();
        hello.setName(env.getProperty("myName1"));
        hello.setPrinter(stringPrinter());
        hello.setNames(nameList());
        return hello;
    }

    @Bean
    public List<String> nameList(){
//        T... 이면 variable argument -> 가변인자, argument 개수가 고정되어 있지 않음.
        String names=env.getProperty("names.list.of.strings");

        return Arrays.asList(names.split(","));
    }
}
