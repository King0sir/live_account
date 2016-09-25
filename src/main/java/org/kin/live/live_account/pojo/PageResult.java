package org.kin.live.live_account.pojo;

import com.alibaba.fastjson.JSON;

/**
 * Created by kingsir on 16-9-25.
 */
public class PageResult {

    public static final Integer success = 1;
    public static final Integer fail = 0;

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private PageResult(){

    }

    private PageResult(Integer code){
        this.code = code;
    }

    private PageResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public static PageResult getSuccess(){
        return new PageResult(success);
    }

    public static PageResult getSuccess(String message){
        return new PageResult(success,message);
    }

    public static PageResult getFail(){
        return new PageResult(fail);
    }

    public static PageResult getFail(String message){
        return new PageResult(fail,message);
    }

    public String toString(){
        return JSON.toJSONString(this,false);
    }
}
