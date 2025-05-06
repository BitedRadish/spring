package mylab.customer.service;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerService {
    List<CustomerVO> getAllCustomerList();
    CustomerVO getCustomerInfo(int id);
    void insertCustomer(CustomerVO customer);

}
