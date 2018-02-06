package top.kou.product.service;

import top.kou.biz.product.Product;
import top.kou.product.model.ProductCreateBo;
import top.kou.product.model.ProductQueryBo;

import java.util.Set;

public interface ProductService {
    Product save(ProductCreateBo createBo);
    Set<Product> lookup(ProductQueryBo queryBo);
}
