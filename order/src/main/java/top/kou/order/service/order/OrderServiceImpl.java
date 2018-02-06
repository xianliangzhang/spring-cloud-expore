package top.kou.order.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.kou.biz.common.Response;
import top.kou.biz.customer.Customer;
import top.kou.biz.order.Order;
import top.kou.biz.order.OrderItem;
import top.kou.biz.product.Product;
import top.kou.order.model.OrderCreateBo;
import top.kou.order.model.OrderQueryBo;
import top.kou.order.service.OrderService;
import top.kou.order.service.remote.RemoteCustomerService;
import top.kou.order.service.remote.RemoteProductService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private Map<Customer, Set<Order>> orders = new HashMap<>();

    @Autowired
    private RemoteProductService remoteProductService;

    @Autowired
    private RemoteCustomerService remoteCustomerService;

    @Override
    public Order save(OrderCreateBo createBo) {
        Customer customer = lookupCustomerById(createBo.getCid());
        if (null == customer) {
            throw new RuntimeException("Customer Not Found: " + createBo.getCid());
        }

        Order order = new Order(customer, getOrderItems(createBo.getItems()));
        orders.putIfAbsent(customer, new HashSet<>());
        orders.get(customer).add(order);
        return order;
    }

    @Override
    public Set<Order> lookup(OrderQueryBo queryBo) {
        boolean hasCustomerFilter = queryBo.hasCustomerFilter();
        Set<Customer> customers = hasCustomerFilter ?
                lookupCustomerByIdAndName(queryBo.getCid(), queryBo.getCname()) :
                orders.keySet();

        Set<Order> target = new HashSet<>();
        customers.stream().filter(c -> orders.containsKey(c)).forEach(c -> target.addAll(getMatchedOrdersCopy(c, queryBo)));
        return target;
    }

    private Customer lookupCustomerById(Integer id) {
        Set<Customer> customers = lookupCustomerByIdAndName(id, null);
        return customers.isEmpty() ? null : customers.iterator().next();
    }

    private Set<Customer> lookupCustomerByIdAndName(Integer id, String name) {
        Response<Set<Customer>> response = remoteCustomerService.lookup(id, name);
        if (response.getCode() == Response.CODE_FAILURE) {
            throw new RuntimeException(response.getMessage());
        }
        return response.getData();
    }

    private Set<OrderItem> getOrderItems(Set<OrderCreateBo.OrderCreateItemBo> orderItems) {
        if (orderItems.isEmpty()) {
            throw new RuntimeException("Products Cannot Be Empty");
        }
        return orderItems.stream().map(item -> getOrderItem(item)).collect(Collectors.toSet());
    }

    private OrderItem getOrderItem(OrderCreateBo.OrderCreateItemBo itemBo) {
        Product product = lookupProductById(itemBo.getPid());
        if (null == product) {
            throw new RuntimeException("Product Not Found: " + itemBo.getPid());
        }
        return new OrderItem(product, itemBo.getCount());
    }

    private Product lookupProductById(Integer id) {
        Set<Product> products = lookupProductByIdAndName(id, null);
        return products.isEmpty() ? null : products.iterator().next();
    }

    private Set<Product> lookupProductByIdAndName(Integer id, String name) {
        Response<Set<Product>> response = remoteProductService.lookup(id, name);
        if (response.getCode() == Response.CODE_FAILURE) {
            throw new RuntimeException(response.getMessage());
        }
        return response.getData();
    }

    private Set<Order> getMatchedOrdersCopy(Customer customer, OrderQueryBo queryBo) {
        Set<Order> originOrders = orders.get(customer);
        Set<Order> copies = new HashSet<>(originOrders.size());
        originOrders.forEach(order -> copies.add(new Order(order.getCustomer(), getMatchedOrderItems(order, queryBo))));
        return copies;
    }

    private Set<OrderItem> getMatchedOrderItems(Order order, OrderQueryBo queryBo) {
        return order.getItems().stream()
                .filter(oi -> queryBo.getPid() == null || Objects.equals(queryBo.getPid(), oi.getProduct().getId()))
                .filter(oi -> StringUtils.isEmpty(queryBo.getPname()) || Objects.equals(queryBo.getPname(), oi.getProduct().getName()))
                .collect(Collectors.toSet());
    }
}
