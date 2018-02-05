package top.kou.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kou.biz.common.Response;
import top.kou.biz.order.Order;
import top.kou.biz.sequence.Sequencer;
import top.kou.biz.user.User;
import top.kou.order.service.RemoteUserService;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private RemoteUserService remoteUserService;

    @RequestMapping("/order/submit")
    public Response<Order> submit(String email, BigDecimal amount) {
        Objects.requireNonNull(email);

        logger.info("Request [url={}, email={}, amount={}]", "/order/submit", email, amount);
        Response<User> response = remoteUserService.lookupUser(email);
        logger.info("Response [status={}, user={}]", response.getCode());

        return Response.CODE_FAILURE == response.getCode() || response.getData() == null ?
                new Response<>(null, Response.CODE_FAILURE, String.format("User Not Registered [email=%s]", email)) :
                new Response<>(getNewOrder(response.getData(), amount));
    }

    private Order getNewOrder(User user, BigDecimal amount) {
        Order order = new Order();
        order.setId(Sequencer.getNextSequence());
        order.setUser(user);
        order.setAmount(amount);
        return order;
    }
}
