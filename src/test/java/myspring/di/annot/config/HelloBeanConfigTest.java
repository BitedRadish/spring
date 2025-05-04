package myspring.di.annot.config;

import myspring.di.annot.HelloBean;
import static org.junit.jupiter.api.Assertions.*;

import myspring.di.annot.PrinterBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class,loader = AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {

    @Autowired
    HelloBean hello;

    @Autowired
    @Qualifier("stringPrinter")
    PrinterBean printer;

    @Test
    void helloAnnotBean(){
        assertEquals("Hello annotation",hello.sayHello());
        hello.print();
        assertEquals("Hello annotation",printer.toString());
    }
}
