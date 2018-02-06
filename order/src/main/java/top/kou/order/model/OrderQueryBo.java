package top.kou.order.model;

import org.springframework.util.StringUtils;

public class OrderQueryBo {
    private Integer cid;
    private String cname;
    private Integer pid;
    private String pname;

    public boolean hasCustomerFilter() {
        return cid != null || !StringUtils.isEmpty(cname);
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
