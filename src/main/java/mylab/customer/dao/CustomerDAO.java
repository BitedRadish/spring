package mylab.customer.dao;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerDAO {
    List<CustomerVO> selectAllCustomer();
    CustomerVO selectCustomer(int id);
    void insertCustomer(CustomerVO customer);
}
