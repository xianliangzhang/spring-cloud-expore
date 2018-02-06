package top.kou.customer.service.customer;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.kou.biz.customer.Customer;
import top.kou.customer.model.CustomerCreateBo;
import top.kou.customer.model.CustomerQueryBo;
import top.kou.customer.service.CustomerService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final Map<String, Customer> customers = new HashMap<>();

    @Override
    public Customer save(CustomerCreateBo createBo) {
        Customer customer = new Customer(createBo.getName(), createBo.getEmail());
        Customer exists = customers.putIfAbsent(customer.getName(), customer);
        if (exists != null) {
            throw new RuntimeException("Customer Exists: " + customer.getName());
        }
        return customer;
    }

    @Override
    public Set<Customer> lookup(CustomerQueryBo queryBo) {
        return customers.values().stream()
                .filter(customer -> queryBo.getId() == null || customer.getId().equals(queryBo.getId()))
                .filter(customer -> StringUtils.isEmpty(queryBo.getName()) || Objects.equals(customer.getName(), queryBo.getName()))
                .filter(customer -> StringUtils.isEmpty(queryBo.getEmail()) || Objects.equals(customer.getEmail(), queryBo.getEmail()))
                .collect(Collectors.toSet());
    }
}
