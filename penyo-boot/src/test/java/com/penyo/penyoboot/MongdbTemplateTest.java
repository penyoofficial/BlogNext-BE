package com.penyo.penyoboot;

import cn.hutool.json.JSONUtil;
import com.penyo.penyoboot.dao.impl.userIdenceDaoImpl;
import com.penyo.penyoboot.model.domain.articles;
import com.penyo.penyoboot.model.form.ArticlesForm;
import com.penyo.penyoboot.service.impl.userIdenceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: 顾壮壮
 * @date: 2023/7/24 16:04
 */
@SpringBootTest
@Slf4j
public class MongdbTemplateTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private userIdenceServiceImpl userIdenceService;

    @Autowired
    private userIdenceDaoImpl userIdenceDao;

    /**
     * 测试mongodb是否连接成功
     */
    @Test
    public void testCollection(){
        boolean all = mongoTemplate.collectionExists(articles.class);
        if (all) {
            log.info("连接成功");
        }
    }

    @Test
    public void testGetAllSlogans(){
        String allSlogans = userIdenceService.getAllSlogans();
        log.info(allSlogans);
    }
    @Test
    public void testGetArticles(){
        ArticlesForm article=new ArticlesForm(null,"2023-6-1","2023-6-30","","",-1);
        Page<articles> stringObjectMap = userIdenceService.selectArticle(article);
        System.out.println(JSONUtil.toJsonStr(stringObjectMap));

    }

}
