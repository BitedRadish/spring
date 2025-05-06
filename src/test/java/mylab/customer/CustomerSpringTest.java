package mylab.customer;

import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring/spring-beans.xml"})
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testInsertAndSelect() {
        // Insert 테스트
        CustomerVO newCustomer = new CustomerVO();
        newCustomer.setEmail("junit@example.com");
        newCustomer.setName("JUnit Tester");
        newCustomer.setAge(28);

        customerService.insertCustomer(newCustomer);
        System.out.println("Insert 완료!");

        // SelectAll 테스트
        List<CustomerVO> customerList = customerService.getAllCustomerList();
        System.out.println("전체 고객 목록:");
        for (CustomerVO customer : customerList) {
            System.out.println(customer);
        }

        // SelectById 테스트
        CustomerVO customer = customerService.getCustomerInfo(1);
        System.out.println("ID=1 고객 정보: " + customer);
    }
}
