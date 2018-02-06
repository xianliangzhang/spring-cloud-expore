package top.kou.biz.order;

import top.kou.biz.customer.Customer;
import top.kou.biz.sequence.Sequencer;

import java.util.Collections;
import java.util.Set;

public class Order {
    private Integer id;
    private Customer customer;
    private Set<OrderItem> items = Collections.emptySet();

    public Order() {
        this.id = Sequencer.getNextSequence();
    }

    public Order(Customer customer, Set<OrderItem> items) {
        this.id = Sequencer.getNextSequence();
        this.customer = customer;
        this.items = items;
    }

    @Override
    public String toString() {
        return String.format("{id=%d, customer=%s, items=%s}", id, customer, items);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }
}
