package top.kou.product.service.product;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.kou.biz.product.Product;
import top.kou.product.model.ProductCreateBo;
import top.kou.product.model.ProductQueryBo;
import top.kou.product.service.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final Map<String, Product> products = new HashMap<>();

    @Override
    public Product save(ProductCreateBo createBo) {
        Product product = new Product(createBo.getName(), createBo.getCost(), createBo.getPrice());
        Product exists = products.putIfAbsent(createBo.getName(), product);
        if (null != exists) {
            throw new RuntimeException("Product Exists: " + product.getName());
        }
        return product;
    }

    @Override
    public Set<Product> lookup(ProductQueryBo queryBo) {
        return products.values().stream()
                .filter(product -> queryBo.getId() == null || Objects.equals(queryBo.getId(), product.getId()))
                .filter(product -> StringUtils.isEmpty(queryBo.getName()) || Objects.equals(queryBo.getName(), product.getName()))
                .collect(Collectors.toSet());
    }
}
