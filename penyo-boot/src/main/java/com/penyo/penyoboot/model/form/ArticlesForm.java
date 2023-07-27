package com.penyo.penyoboot.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: 顾壮壮
 * @date: 2023/7/25 10:51
 */
@Data
@AllArgsConstructor
@Schema(description = "文章表单对象")
public class ArticlesForm {

    @Schema(description = "文章id")
    private String id;

    @Schema(description = "起始时间")
    private String from;

    @Schema(description = "结束时间")
    private String to;

    @Schema(description = "文章分类")
    private String category;

    @Schema(description = "关键词")
    private String keyword;

//    @NotEmpty(message = "页数不能为空")
    @Schema(description = "页数")
    private Integer page;
}