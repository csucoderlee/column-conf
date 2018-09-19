package org.csu.service;

import org.csu.model.Account;
import org.csu.model.ColumnConfigListWrapper;
import org.csu.model.ColumnConfigVO;

import java.util.List;

public interface IColumnConfigService {

    /**
     * 不同用户的列配置不一样， 所以这里account 可以理解是个接口，不同的系统有其自己的账号会话
     * @param account
     * @param pageId
     * @return
     */
    ColumnConfigListWrapper getColumnConfigList(Account account, Long pageId);

    /**
     * 用户去勾选自己想要显示的列配置，需要保存相关的配置
     * @param account
     * @param pageId
     * @param columnConfigVOList
     */
    void updateColumnConfig(Account account, Long pageId, List<ColumnConfigVO> columnConfigVOList);

}
