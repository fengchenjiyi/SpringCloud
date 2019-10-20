package com.yaoln.api.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoln.api.entitys.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 22:24
 */
public abstract class BaseServiceImpl<T extends BaseEntity> {

    @Autowired
    protected BaseMapper<T> mapper;
    @Value("${page_num_max}")
    protected int pageNumMax;

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    public T queryById(Long id) {
        return this.mapper.selectById(id);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> queryAll(Wrapper<T> wrapper) {
        return this.mapper.selectList(wrapper);
    }

    /**
     * 根据条件查询一条数据
     *
     * @param entity
     * @return
     */
    public T queryOne(T entity) {
        return this.mapper.selectOne(new QueryWrapper<>(entity));
    }

    /**
     * 根据条件查询数据列表
     *
     * @param entity
     * @return
     */
    public List<T> queryListByWhere(T entity) {
        return this.mapper.selectList(new QueryWrapper<>(entity));
    }

    /**
     * 根据条件分页查询数据列表
     *
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<T> queryPageListByWhere(T entity, Integer pageNum, Integer pageSize) {
        // 获取分页数据
        return this.mapper.selectPage(new Page<T>(pageNum, pageSize), new QueryWrapper<>(entity));
    }

    /**
     * 根据条件分页查询数据列表
     *
     * @param queryWrapper
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<T> queryPageList(QueryWrapper<T> queryWrapper, Integer pageNum, Integer pageSize) {
        // 获取分页数据
        return this.mapper.selectPage(new Page<T>(pageNum, pageSize), queryWrapper);
    }


    /**
     * 保存数据
     *
     * @param entity
     * @return
     */
    public Integer insert(T entity) {
        entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return this.mapper.insert(entity);
    }

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public Integer update(T entity) {
        entity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return this.mapper.updateById(entity);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return this.mapper.deleteById(id);
    }

    /**
     * 根据ids批量删除数据
     *
     * @param ids
     * @return
     */
    public Integer deleteByIds(List<Long> ids) {
        return this.mapper.deleteBatchIds(ids);
    }

    /**
     * 根据条件删除数据
     *
     * @param entity
     * @return
     */
    public Integer deleteByWhere(T entity) {
        return this.mapper.delete(new QueryWrapper<>(entity));
    }
}
