package top.kou.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.kou.biz.common.Response;
import top.kou.biz.user.User;
import top.kou.order.hystrix.RemoteUserServiceHystrix;

@FeignClient(name = "User-Agent", fallback = RemoteUserServiceHystrix.class)
public interface RemoteUserService {

    @RequestMapping("/user/lookup")
    Response<User> lookupUser(@RequestParam("email") String email);
}
