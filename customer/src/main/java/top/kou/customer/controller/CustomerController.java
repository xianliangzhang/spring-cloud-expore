package top.kou.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kou.biz.common.Response;
import top.kou.biz.customer.Customer;
import top.kou.customer.model.CustomerCreateBo;
import top.kou.customer.model.CustomerQueryBo;
import top.kou.customer.service.CustomerService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Set;

@RestController
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer/register")
    public Response<Customer> register(@Valid CustomerCreateBo createBo) {
        logger.info("Request Register Customer: {}", createBo.toString());
        try {
            Customer customer = customerService.save(createBo);
            logger.info("Customer Registered: {}", customer.toString());
            return new Response<>(customer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new Response<>(null, Response.CODE_FAILURE, Response.MESSAGE_FAILURE);
        }
    }

    @RequestMapping("/customer/lookup")
    public Response<Set<Customer>> lookup(@Valid CustomerQueryBo queryBo) {
        logger.info("Request Customer Query: {}", queryBo.toString());
        try {
            Set<Customer> customers = customerService.lookup(queryBo);
            logger.info("Response Customer Query: {}", customers);
            return new Response<>(customers);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new Response<>(Collections.emptySet(), Response.CODE_FAILURE, Response.MESSAGE_FAILURE);
        }
    }
}
