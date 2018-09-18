package org.csu.model;

import java.io.Serializable;

/**
 * Created by csucoderlee on 2018/9/18
 * 用户级别的页面配置
 */
public class UserColumnConfig implements Serializable {

    /**
     * 账号id
     */
    private Long accountId;

    /**
     * 列所属页面ID
     */
    private Long pageId;

    /**
     * 列ID
     */
    private Long colId;

    /**
     * 是否可见: 1可见, 0不可见
     */
    private Integer visible;

    /**
     * 列在当前页面的排序号
     */
    private Integer sortNo;

    /**
     * 列宽度
     */
    private Integer width;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getColId() {
        return colId;
    }

    public void setColId(Long colId) {
        this.colId = colId;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
