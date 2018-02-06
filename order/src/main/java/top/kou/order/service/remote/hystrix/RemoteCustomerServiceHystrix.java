package top.kou.order.service.remote.hystrix;

import org.springframework.stereotype.Service;
import top.kou.biz.common.Response;
import top.kou.biz.customer.Customer;
import top.kou.order.service.remote.RemoteCustomerService;

import java.util.Collections;
import java.util.Set;

@Service
public class RemoteCustomerServiceHystrix implements RemoteCustomerService {
    @Override
    public Response<Set<Customer>> lookup(Integer id, String name) {
        return new Response<>(Collections.emptySet(), Response.CODE_FAILURE, Response.MESSAGE_FAILURE);
    }
}
