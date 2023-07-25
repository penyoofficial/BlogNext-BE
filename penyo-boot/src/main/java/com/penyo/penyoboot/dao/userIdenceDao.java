package com.penyo.penyoboot.dao;

import com.penyo.penyoboot.pojo.entity.slogan;

import java.util.List;

/**
 * @description:
 * @author: 顾壮壮
 * @date: 2023/7/25 11:14
 */
public interface userIdenceDao {
    /**
     * 得到所有标语
     *
     * @return {@link List}<{@link slogan}>
     */
    public List<slogan> getAllSlogans();
}
