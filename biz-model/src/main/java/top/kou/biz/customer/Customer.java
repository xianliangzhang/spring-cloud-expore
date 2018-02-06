package top.kou.biz.customer;

import top.kou.biz.sequence.Sequencer;

import java.util.Objects;

public class Customer {
    private Integer id;
    private String name;
    private String email;

    public Customer() {
        this.id = Sequencer.getNextSequence();
    }

    public Customer(String name, String email) {
        this.id = Sequencer.getNextSequence();
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("{id=%d, name=%s, email=%s}", id, name, email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id) + Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Customer.class) {
            return false;
        }
        return Objects.equals(id, ((Customer) obj).id) || Objects.equals(name, ((Customer) obj).name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
