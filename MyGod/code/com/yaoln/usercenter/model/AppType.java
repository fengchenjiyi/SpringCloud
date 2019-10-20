package com.yaoln.usercenter.model;

import java.util.Date;

/**
 * 描述:tab_app_type表的实体类
 * @version
 * @author:  290879584
 * @创建时间: 2019-10-19
 */
public class AppType {
    /**
     * id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 表索引
     */
    private Byte tabIndex;

    /**
     * 表名
     */
    private String tabName;

    /**
     * 应用标识
     */
    private String appKey;

    /**
     * 应用描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * id
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用名称
     * @return app_name 应用名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用名称
     * @param appName 应用名称
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 表索引
     * @return tab_index 表索引
     */
    public Byte getTabIndex() {
        return tabIndex;
    }

    /**
     * 表索引
     * @param tabIndex 表索引
     */
    public void setTabIndex(Byte tabIndex) {
        this.tabIndex = tabIndex;
    }

    /**
     * 表名
     * @return tab_name 表名
     */
    public String getTabName() {
        return tabName;
    }

    /**
     * 表名
     * @param tabName 表名
     */
    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
    }

    /**
     * 应用标识
     * @return app_key 应用标识
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * 应用标识
     * @param appKey 应用标识
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    /**
     * 应用描述
     * @return description 应用描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 应用描述
     * @param description 应用描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}