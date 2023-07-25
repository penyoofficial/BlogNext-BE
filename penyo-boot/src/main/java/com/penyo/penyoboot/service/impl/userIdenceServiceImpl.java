package com.penyo.penyoboot.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.penyo.penyoboot.dao.impl.userIdenceDaoImpl;
import com.penyo.penyoboot.pojo.entity.slogan;
import com.penyo.penyoboot.service.userIdenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
}
