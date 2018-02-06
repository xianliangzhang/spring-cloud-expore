package top.kou.order.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.kou.biz.common.Response;
import top.kou.biz.customer.Customer;
import top.kou.order.service.remote.hystrix.RemoteCustomerServiceHystrix;

import java.util.Set;

@FeignClient(name = "Customer-Service", fallback = RemoteCustomerServiceHystrix.class)
public interface RemoteCustomerService {

    @RequestMapping("/customer/lookup")
    Response<Set<Customer>> lookup(@RequestParam("id") Integer id, @RequestParam("name") String name);
}
