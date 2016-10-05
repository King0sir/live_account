package org.kin.live.live_account.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by kingsir on 16-9-27.
 */
public class SimpleUser {

    private String userId;

    private String nickName;

    public SimpleUser() {
    }

    public SimpleUser(String userId, String nickName) {
        this.userId = userId;
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
