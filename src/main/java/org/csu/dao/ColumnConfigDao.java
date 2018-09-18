package org.csu.dao;

import org.csu.model.Account;
import org.csu.model.PageColumnConfig;
import org.csu.model.UserColumnConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csucoderlee on 2018/9/18
 */
public class ColumnConfigDao {
    public List<PageColumnConfig> getPageColumnConfigList(Long pageId) {
        return new ArrayList<>();
    }

    public List<UserColumnConfig> getUserColumnConfigList(Account account, Long pageId) {
        return new ArrayList<>();
    }

    public void deleteUserColumnConfigList(Account account, Long pageId) {}

    public void insertUserColumnConfigList(Account account, List<UserColumnConfig> list) {}
}
