package org.csu.model;

import java.io.Serializable;

/**
 * Created by csucoderlee on 2018/9/18
 * 返回给前端视图
 */
public class ColumnConfigVO implements Serializable {

    private static final long serialVersionUID = -535628316343525052L;
    /**
     * 列编码
     */
    private String field;

    /**
     * 列显示标题
     */
    private String title;

    /**
     * 是否可见: 1可见, 0不可见
     */
    private Integer visible;

    /**
     * 列ID
     */
    private Long colId;

    /**
     * 列宽度
     */
    private Integer width;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Long getColId() {
        return colId;
    }

    public void setColId(Long colId) {
        this.colId = colId;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
