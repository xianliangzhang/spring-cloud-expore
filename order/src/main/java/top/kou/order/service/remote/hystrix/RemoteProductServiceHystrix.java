package top.kou.order.service.remote.hystrix;

import org.springframework.stereotype.Service;
import top.kou.biz.common.Response;
import top.kou.biz.product.Product;
import top.kou.order.service.remote.RemoteProductService;

import java.util.Collections;
import java.util.Set;

@Service
public class RemoteProductServiceHystrix implements RemoteProductService {
    @Override
    public Response<Set<Product>> lookup(Integer id, String name) {
        return new Response<>(Collections.emptySet(), Response.CODE_FAILURE, Response.MESSAGE_FAILURE);
    }
}
