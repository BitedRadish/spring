package myspring.di.xml.config;

import myspring.di.annot.PrinterBean;
import myspring.di.xml.Hello;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class)
public class HelloConfigTest {
    @Autowired
    List<String> namesList;

    @Autowired
    Hello hello;

    @Resource
    PrinterBean printer;

    @Test
    void testHelloConfig(){
        assertEquals("Hello spring",hello.sayHello());
        hello.print();
        assertEquals("Hello spring",printer.toString());
        assertEquals("Java",hello.getNames().get(0));
    }

    @Test
    void testNameList(){
        for (String name:namesList){
            System.out.println(name);
        }
    }
}
