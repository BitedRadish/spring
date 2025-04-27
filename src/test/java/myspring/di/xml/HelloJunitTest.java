package myspring.di.xml;

//Assertions에 포함된 모든 static method를 import 한다.
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class HelloJunitTest {
    ApplicationContext context;
    @BeforeEach
    void container(){
//        1. Container 객체 생성
        ApplicationContext context=new GenericXmlApplicationContext("classpath:hello-di.xml");
    }

    @Test
    void helloBean(){
//        target.classes에서 탐색

//        2. Container 객체가 생성한 Spring Bean을 요청하기
        Hello helloById=(Hello) context.getBean("hello");
//        타입을 명시해줌.
        Hello helloByType=context.getBean("hello",Hello.class);

//        Spring Bean의 주소 비교
//        싱글톤인지 아닌지 확인하기 위해
        System.out.println(helloById==helloByType);
        assertSame(helloById,helloByType);
        assertEquals("Hello 스프링",helloById.sayHello());

        helloById.print();
//        Container 객체가 생성한 StringPrinter 스프링 빈을 요청하기
        Printer printer=context.getBean("strPrinter",Printer.class);
        assertEquals("Hello 스프링",printer.toString());
    }
}
