package top.kou.order.service;

import top.kou.biz.order.Order;
import top.kou.order.model.OrderCreateBo;
import top.kou.order.model.OrderQueryBo;

import java.util.Set;

public interface OrderService {
    Order save(OrderCreateBo createBo);
    Set<Order> lookup(OrderQueryBo queryBo);
}
