package org.kin.live.live_account.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * Created by kingsir on 16-10-10.
 */
public class HisTrans implements Serializable{

    private String transAmt;

    private String payer;

    private String payTime;

    private String perAmt;

    private String memo;

    private String image;

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPerAmt() {
        return perAmt;
    }

    public void setPerAmt(String perAmt) {
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

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
