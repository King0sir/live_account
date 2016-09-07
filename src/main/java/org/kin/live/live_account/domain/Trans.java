package org.kin.live.live_account.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Trans {
    private Integer id;

    private BigDecimal transAmt;

    private String payerId;

    private String groupId;

    private Date payTime;

    private Integer divideTo;

    private BigDecimal perAmt;

    private String memo;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getDivideTo() {
        return divideTo;
    }

    public void setDivideTo(Integer divideTo) {
        this.divideTo = divideTo;
    }

    public BigDecimal getPerAmt() {
        return perAmt;
    }

    public void setPerAmt(BigDecimal perAmt) {
        this.perAmt = perAmt;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}