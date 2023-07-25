package com.penyo.penyoboot.pojo.form;

import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * @description:
 * @author: 顾壮壮
 * @date: 2023/7/25 10:51
 */
@Schema(description = "文章表单对象")
public class ArticlesForm {

    @Schema(description = "系统默认id")
    private ObjectId _id;

    @Schema(description = "文章id")
    private String id;

    @Schema(description = "文章标题")
    private String title;

    @Schema(description = "文章写作时间")
    private Date time;

    @Schema(description = "文章分类")
    private String category;

    @Schema(description = "文章内容")
    private String body;
}