package org.csu.model;

import java.io.Serializable;

/**
 * Created by csucoderlee on 2018/9/18
 * 正常页面的字段配置
 */
public class PageColumnConfig implements Serializable {

    /**
     * 列配置项ID
     */
    private Long id;

    /**
     * 列编码
     */
    private String colCode;

    /**
     * 列显示标题
     */
    private String colTitle;

    /**
     * 列所属页面ID
     */
    private Long pageId;

    /**
     * 是否为该页面默认显示的列
     */
    private Integer isDefault;

    /**
     * 列在当前页面的排序号
     */
    private Integer sortNo;

    /**
     * 列宽度
     */
    private Integer width;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColCode() {
        return colCode;
    }

    public void setColCode(String colCode) {
        this.colCode = colCode;
    }

    public String getColTitle() {
        return colTitle;
    }

    public void setColTitle(String colTitle) {
        this.colTitle = colTitle;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
