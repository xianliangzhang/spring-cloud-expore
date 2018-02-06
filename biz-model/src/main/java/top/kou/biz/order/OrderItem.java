package top.kou.biz.order;

import top.kou.biz.product.Product;

public class OrderItem {
    private int count;
    private Product product;

    public OrderItem() {

    }

    public OrderItem(Product product, int count) {
        this.count = count;
        this.product = product;
    }

    @Override
    public String toString() {
        return String.format("{product=%s, count=%d}", product, count);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
