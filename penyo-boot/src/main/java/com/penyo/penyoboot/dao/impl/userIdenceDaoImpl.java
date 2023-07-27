package com.penyo.penyoboot.dao.impl;

import cn.hutool.json.JSONUtil;
import com.penyo.penyoboot.dao.userIdenceDao;
import com.penyo.penyoboot.model.domain.articles;
import com.penyo.penyoboot.model.domain.slogan;
import com.penyo.penyoboot.model.query.SpringDataPageable;
import com.penyo.penyoboot.utils.CalendarUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.regex.Pattern;

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

    @Override
    public Page<articles> getArticles(String id,String from, String to, String category, String keyword, Integer page) {
        SpringDataPageable pageable = new SpringDataPageable();
        List<Sort.Order> orders = new ArrayList<Sort.Order>();  //排序
        orders.add(new Sort.Order(Sort.Direction.DESC, "time"));
        Sort sort = Sort.by(orders);
        // 每页条数
        pageable.setPagesize(10);
        // 排序
        pageable.setSort(sort);
        if (page<=0){
            page=1;
            // 开始页
            pageable.setPagenumber(page);
            return PageUtil(new Query(Criteria.where("time").lt(new Date(0,0,0))),pageable);
        }
        // 开始页
        pageable.setPagenumber(page);
        if (StringUtils.isNotBlank(id)) {
            Query query = new Query(Criteria.where("id").is(id));
            return PageUtil(query,pageable);
        }
        if(StringUtils.isBlank(from)&&StringUtils.isBlank(to)&&StringUtils.isBlank(category)&&StringUtils.isBlank(keyword)){//获取总个数
            Query query = new Query();
            return PageUtil(query,pageable);

        }
        ArrayList<Criteria> list = new ArrayList<Criteria>();
        Date From=null;
        Date To=null;
        Criteria criteria =new Criteria();
        if (StringUtils.isNotBlank(from)||StringUtils.isNotBlank(to)){
            if (StringUtils.isNotBlank(from)){
                From = CalendarUtil.getDateFrom(from);
                list.add(Criteria.where("time").gte(From));
            }
            if (StringUtils.isNotBlank(to)){
                To = CalendarUtil.getDateTo(to);
                list.add(Criteria.where("time").lte(To));
            }
        }
        if (StringUtils.isNotBlank(category)) list.add(Criteria.where("category").is(category));
        if (StringUtils.isNotBlank(keyword)){
            Pattern pattern = Pattern.compile("^.*"+keyword+".*$", Pattern.CASE_INSENSITIVE);
            list.add(Criteria.where("body").regex(pattern));
        }
        Query query =new Query();
        Criteria[] arr = new Criteria[list.size()];
        if (arr.length > 0){
            list.toArray(arr);
            Criteria criteria1 = new Criteria().andOperator(arr);
            query.addCriteria(criteria1);
        }
        return PageUtil(query,pageable);
    }

    /**
     * 页面工具函数
     *
     * @param query    查询
     * @param pageable 分页
     * @return {@link Page}<{@link articles}>
     */
    public Page<articles> PageUtil(Query query,Pageable pageable){
        long count = mongoTemplate.count(query, articles.class);
        // 查询
        List<articles> list = mongoTemplate.find(query.with(pageable), articles.class);
        // 将集合与分页结果封装
        Page<articles> pagelist = new PageImpl<articles>(list, pageable, count);
        return pagelist;
    }
}
