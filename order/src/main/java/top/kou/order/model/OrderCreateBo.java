package top.kou.order.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

public class OrderCreateBo {
    @NotNull(message = "Customer ID Cannot Be Null")
    private Integer cid;
    private Set<OrderCreateItemBo> items = Collections.emptySet();

    public static class OrderCreateItemBo {
        @NotNull(message = "Product ID Cannot Be Null")
        private Integer pid;

        @Min(value = 1, message = "Product's Count Cannot Little Than Zero")
        private Integer count;

        public Integer getPid() {
            return pid;
        }

        public void setPid(Integer pid) {
            this.pid = pid;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Set<OrderCreateItemBo> getItems() {
        return items;
    }

    public void setItems(Set<OrderCreateItemBo> items) {
        this.items = items;
    }
}
