package com.penyo.penyoboot.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @description:文档实体类
 * @author: 顾壮壮
 * @date: 2023/7/24 16:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("articles")
public class articles {
    //系统默认id
    @Id
    private ObjectId _id;

    //文章id
    @Field("id")
    private String id;

    //文章标题
    @Field("title")
    private String title;

    //文章写作时间
    @Field("time")
    private Date time;

    //文章分类
    @Field("category")
    private String category;

    //文章内容
    @Field("body")
    private String body;

}
