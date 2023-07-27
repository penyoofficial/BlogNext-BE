package com.penyo.penyoboot.service.impl;

import cn.hutool.json.JSONUtil;
import com.penyo.penyoboot.dao.impl.userIdenceDaoImpl;
import com.penyo.penyoboot.model.domain.articles;
import com.penyo.penyoboot.model.domain.slogan;
import com.penyo.penyoboot.model.form.ArticlesForm;
import com.penyo.penyoboot.service.userIdenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: 顾壮壮
 * @date: 2023/7/25 10:40
 */
@Service
@RequiredArgsConstructor
public class userIdenceServiceImpl implements userIdenceService {

    private final userIdenceDaoImpl userIdenceDao;
    @Override
    public String getAllSlogans() {
        List<slogan> slogans = userIdenceDao.getAllSlogans();
        return JSONUtil.toJsonStr(slogans);
    }

    @Override
    public Page<articles> selectArticle(ArticlesForm articlesForm) {
        return userIdenceDao.getArticles(
                articlesForm.getId(),
                articlesForm.getFrom(),
                articlesForm.getTo(),
                articlesForm.getCategory(),
                articlesForm.getKeyword(),
                articlesForm.getPage());
    }
}
