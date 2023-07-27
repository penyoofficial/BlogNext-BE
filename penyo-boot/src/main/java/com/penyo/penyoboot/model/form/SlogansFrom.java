package com.penyo.penyoboot.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.types.ObjectId;

/**
 * @description:口号表单对象
 * @author: 顾壮壮
 * @date: 2023/7/25 10:47
 */
@Schema(description = "口号表单对象")
public class SlogansFrom {

    @Schema(description = "系统默认id")
    private ObjectId _id;

    @Schema(description = "标语")
    private String value;
}
