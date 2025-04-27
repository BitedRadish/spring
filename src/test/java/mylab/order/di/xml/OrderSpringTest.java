package mylab.order.di.xml;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
    @Autowired
    OrderService orderService;

    @Autowired
    ShoppingCart shoppingCart;

    @Test
    void shopping() {
        System.out.println(shoppingCart.getProducts());
        assertEquals(30000.0,shoppingCart.getTotalPrice());
        assertEquals(30000.0,orderService.calculateOrderTotal());
    }

}
