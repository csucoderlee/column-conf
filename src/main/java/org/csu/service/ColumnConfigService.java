package org.csu.service;

import org.csu.dao.ColumnConfigDao;
import org.csu.model.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csucoderlee on 2018/9/18
 */
public class ColumnConfigService implements IColumnConfigService{

    public static final String COLUMN_CONF_CACHE_PREFIX = "column_config_vo_";

    public static final String PAGE_COLUMN_CONF_CACHE_PREFIX = "page_column_config_";

    Map<String, ColumnConfigListWrapper> cache1 = new HashMap<>();
    Map<String, List<PageColumnConfig>> cache2 = new HashMap<>();

    @Resource
    ColumnConfigDao columnConfigDao;

    @Override
    public ColumnConfigListWrapper getColumnConfigList(Account account, Long pageId) {

        //todo  account 不同系统的账号会话不同

        ColumnConfigListWrapper value;

        String key = COLUMN_CONF_CACHE_PREFIX + account.getId()+ "_" + pageId;


        //todo 这个地方要从缓存服务中取缓存中的数据 记得try catch
        value = cache1.get(key);
        if(null != value) {
            return value;
        } else {
            List<PageColumnConfig> pageColumnConfList = getPageColumnConfigList(account, pageId);
            Map<Long, PageColumnConfig> pageColumnConfMapList = new HashMap<Long, PageColumnConfig>();
            for(PageColumnConfig pageColumnConf : pageColumnConfList) {
                pageColumnConfMapList.put(pageColumnConf.getId(), pageColumnConf);
            }
            List<UserColumnConfig> userColumnConfList = columnConfigDao.getUserColumnConfigList(account, pageId);
            List<ColumnConfigVO> columnConfList = new ArrayList<ColumnConfigVO>();
            Boolean isDefault = false;
            if(userColumnConfList.size() > 0) {
                ColumnConfigVO columnConf;
                PageColumnConfig pageColumnConf;
                for (UserColumnConfig userColumnConf : userColumnConfList) {
                    pageColumnConf = pageColumnConfMapList.remove(userColumnConf.getColId());
                    if(null == pageColumnConf) {
                        //todo 适当的处理异常
                        continue;
                    }
                    columnConf = new ColumnConfigVO();
                    columnConf.setField(pageColumnConf.getColCode());
                    columnConf.setTitle(pageColumnConf.getColTitle());
                    columnConf.setVisible(userColumnConf.getVisible());
                    columnConf.setColId(userColumnConf.getColId());
                    columnConf.setWidth(userColumnConf.getWidth());
                    columnConfList.add(columnConf);
                }
                for (Map.Entry<Long, PageColumnConfig> entry : pageColumnConfMapList.entrySet()) {
                    pageColumnConf = entry.getValue();
                    columnConf = new ColumnConfigVO();
                    columnConf.setField(pageColumnConf.getColCode());
                    columnConf.setTitle(pageColumnConf.getColTitle());
                    columnConf.setVisible(pageColumnConf.getIsDefault());
                    columnConf.setColId(pageColumnConf.getId());
                    columnConf.setWidth(pageColumnConf.getWidth());
                    columnConfList.add(columnConf);
                }
            } else {
                columnConfList = getDefaultColumnConfig(account, pageId);
                isDefault = true;
            }
            ColumnConfigListWrapper columnConfListWrapper = new ColumnConfigListWrapper(columnConfList, isDefault);
            cache1.put(key, columnConfListWrapper);
            return columnConfListWrapper;
        }
    }

    @Override
    public void updateColumnConfig(Account account, Long pageId, List<ColumnConfigVO> columnConfigVOList) {
        String key = COLUMN_CONF_CACHE_PREFIX + account.getId() + "_" + pageId;
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("pageId", pageId);
        columnConfigDao.deleteUserColumnConfigList(account, pageId);
        List<UserColumnConfig> userColumnConfigList = new ArrayList<UserColumnConfig>();
        UserColumnConfig userColumnConfig;
        ColumnConfigVO columnConfigVO;
        for(int i = 0; i < columnConfigVOList.size(); i++) {
            columnConfigVO = columnConfigVOList.get(i);
            userColumnConfig = new UserColumnConfig();
            userColumnConfig.setAccountId(account.getId());
            userColumnConfig.setPageId(pageId);
            userColumnConfig.setColId(columnConfigVO.getColId());
            userColumnConfig.setVisible(columnConfigVO.getVisible());
            userColumnConfig.setSortNo(i);
            userColumnConfig.setWidth(columnConfigVO.getWidth());
            userColumnConfigList.add(userColumnConfig);
        }
        columnConfigDao.insertUserColumnConfigList(account, userColumnConfigList);
        ColumnConfigListWrapper columnConfListWrapper = new ColumnConfigListWrapper(columnConfigVOList, false);
        cache1.put(key, columnConfListWrapper);
    }

    private List<PageColumnConfig> getPageColumnConfigList(Account account, Long pageId) {
        List<PageColumnConfig> value;
        String key = PAGE_COLUMN_CONF_CACHE_PREFIX + pageId;

        value = cache2.get(key);

        if(null != value && value.size() > 0) {
            return value;
        } else {
            List<PageColumnConfig> pageColumnConfigList = columnConfigDao.getPageColumnConfigList(pageId);
            cache2.put(key, pageColumnConfigList);
            return pageColumnConfigList;
        }
    }

    private List<ColumnConfigVO> getDefaultColumnConfig(Account account, Long pageId) {
        List<PageColumnConfig> pageColumnConfigList = getPageColumnConfigList(account, pageId);
        List<ColumnConfigVO> columnConfigVOList = new ArrayList<ColumnConfigVO>();
        ColumnConfigVO columnConfVO;
        for(PageColumnConfig pageColumnConfig : pageColumnConfigList) {
            columnConfVO = new ColumnConfigVO();
            columnConfVO.setField(pageColumnConfig.getColCode());
            columnConfVO.setTitle(pageColumnConfig.getColTitle());
            columnConfVO.setVisible(pageColumnConfig.getIsDefault());
            columnConfVO.setColId(pageColumnConfig.getId());
            columnConfVO.setWidth(pageColumnConfig.getWidth());
            columnConfigVOList.add(columnConfVO);
        }
        return columnConfigVOList;
    }
}
