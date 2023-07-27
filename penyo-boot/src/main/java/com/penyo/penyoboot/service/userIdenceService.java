package com.penyo.penyoboot.service;

import com.penyo.penyoboot.model.domain.articles;
import com.penyo.penyoboot.model.form.ArticlesForm;
import org.springframework.data.domain.Page;

/**
 * @description:
 * @author: 顾壮壮
 * @date: 2023/7/25 10:39
 */

public interface userIdenceService {
    /**
     * 得到所有标语
     *
     * @return {@link String}
     */
    String getAllSlogans();

    /**
     * 选择文章
     *
     * @param articlesForm 文章表单
     * @return {@link String}
     */
    Page<articles> selectArticle(ArticlesForm articlesForm);
}
