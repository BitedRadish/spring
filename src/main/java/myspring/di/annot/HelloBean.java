package myspring.di.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

//id 명시
@Component("helloBean")
public class HelloBean {
	@Value("${myName}")
	String name;

//	autowired는 동적으로 치환자 쓰는 거 사용 불가
//	@Autowired
//	@Qualifier("stringPrinter")

//	@Resource(name="${myPrinter}")
	@Value("${myPrinter}")
	PrinterBean printer;

	@Value("#{'${names.list.of.strings}'.split(',')}")
	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName()+" 기본 생성자 호출됨 !");
	}

	public HelloBean(String name, PrinterBean printer) {
		System.out.println(this.getClass().getName()+" 오버로딩 생성자 호출됨 !");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

//	public void setNames(List<String> list) {
//		System.out.println("setNames() 메서드 호출됨 !");
//		this.names = list;
//	}

	public void setName(String name) {
		System.out.println("setName() 메서드 호출됨 !");
		this.name = name;
	}

//	public void setPrinter(PrinterBean printer) {
//		System.out.println("setPrinter() 메서드 호출됨 !");
//		this.printer = printer;
//	}

	public String sayHello() {
		System.out.println("setPrinter() 메서드 호출됨 !"+printer.getClass().getName());

		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
