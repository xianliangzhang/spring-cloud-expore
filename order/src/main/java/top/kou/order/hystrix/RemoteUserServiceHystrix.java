package top.kou.order.hystrix;

import org.springframework.stereotype.Component;
import top.kou.biz.common.Response;
import top.kou.biz.user.User;
import top.kou.order.service.RemoteUserService;

@Component
public class RemoteUserServiceHystrix implements RemoteUserService {

    @Override
    public Response<User> lookupUser(String email) {
        return new Response<>(getBadUser("LookupByHystrix"));
    }

    private User getBadUser(String name) {
        User badUser = new User();
        badUser.setId(0);
        badUser.setName(name);
        badUser.setEmail(name.concat("@qq.com"));
        return badUser;
    }
}
