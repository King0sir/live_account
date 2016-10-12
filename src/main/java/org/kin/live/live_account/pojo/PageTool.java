package org.kin.live.live_account.pojo;

/**
 * Created by kingsir on 16-10-10.
 */
public class PageTool {

    private Integer startIndex;

    private Integer count;

    private Integer totalCount;

    public PageTool() {
        this.startIndex = 0;
        this.count = 10;
    }

    public PageTool(Integer startIndex) {
        this.startIndex = startIndex;
        this.count = 10;
    }

    public PageTool(Integer startIndex, Integer count) {
        this.startIndex = startIndex;
        this.count = count;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setPage(Integer page){
        this.startIndex = (page - 1) * this.count;
    }

    public Integer getTotalPage(){
        return this.totalCount/this.count + 1;
    }

    public Integer getPage(){
        return this.startIndex / this.count + 1;
    }
}
