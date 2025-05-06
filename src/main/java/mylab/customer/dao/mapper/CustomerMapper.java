package mylab.customer.dao.mapper;

import mylab.customer.vo.CustomerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<CustomerVO> selectAllCustomer();

    CustomerVO selectCustomerById(int id);

    void insertCustomer(CustomerVO customer);
}
