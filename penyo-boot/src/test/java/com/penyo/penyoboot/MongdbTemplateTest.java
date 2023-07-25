package com.penyo.penyoboot;

import com.penyo.penyoboot.pojo.entity.articles;
import com.penyo.penyoboot.service.impl.userIdenceServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

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

}
