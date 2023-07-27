package com.penyo.penyoboot.dao;

import com.penyo.penyoboot.model.domain.articles;
import com.penyo.penyoboot.model.domain.slogan;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * 得到文章
     *
     * @param id       id
     * @param from     起始时间
     * @param to       结束时间
     * @param category 类别
     * @param keyword  关键字
     * @param page     当前页面
     * @return {@link Page}<{@link articles}>
     */
    Page<articles> getArticles(String id,String from, String to, String category, String keyword, Integer page);

}
