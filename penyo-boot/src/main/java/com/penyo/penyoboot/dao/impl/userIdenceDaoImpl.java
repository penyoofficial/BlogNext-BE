package com.penyo.penyoboot.dao.impl;

import com.penyo.penyoboot.dao.userIdenceDao;
import com.penyo.penyoboot.pojo.entity.slogan;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: 顾壮壮
 * @date: 2023/7/25 11:14
 */
@Repository
@RequiredArgsConstructor
public class userIdenceDaoImpl implements userIdenceDao {

    private final MongoTemplate mongoTemplate;
    @Override
    public List<slogan> getAllSlogans() {
        return mongoTemplate.findAll(slogan.class);
    }
}
