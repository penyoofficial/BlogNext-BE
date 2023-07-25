package com.penyo.penyoboot.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @description:文档实体类
 * @author: 顾壮壮
 * @date: 2023/7/24 16:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("slogans")
public class slogan {
    //系统默认id
    @Id
    private ObjectId _id;

    //标语
    @Field("value")
    private String value;

}
