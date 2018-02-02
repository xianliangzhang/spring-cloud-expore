package top.kou.biz.order;

import top.kou.biz.user.User;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
    private Integer id;
    private User user;
    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Order[id=%d, user=%s, amount=%s]", id, Objects.toString(user), amount);
    }
}
