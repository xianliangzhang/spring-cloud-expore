package top.kou.customer.service;

import top.kou.biz.customer.Customer;
import top.kou.customer.model.CustomerCreateBo;
import top.kou.customer.model.CustomerQueryBo;

import java.util.Set;

public interface CustomerService {
    Customer save(CustomerCreateBo createBo);
    Set<Customer> lookup(CustomerQueryBo queryBo);
}
