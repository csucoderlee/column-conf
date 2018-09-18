package org.csu.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by csucoderlee on 2018/9/18
 */
public class ColumnConfigListWrapper implements Serializable {

    private List<ColumnConfigVO> columnConfigVOList;

    private Boolean isDefault;

       public ColumnConfigListWrapper() {
    }

    public ColumnConfigListWrapper(List<ColumnConfigVO> columnConfigVOList, Boolean isDefault) {
        this.columnConfigVOList = columnConfigVOList;
        this.isDefault = isDefault;
    }

    public List<ColumnConfigVO> getColumnConfigVOList() {
        return columnConfigVOList;
    }

    public void setColumnConfigVOList(List<ColumnConfigVO> columnConfigVOList) {
        this.columnConfigVOList = columnConfigVOList;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}
