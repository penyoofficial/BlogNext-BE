package com.penyo.penyoboot.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "起始时间")
    private String from;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "结束时间")
    private String to;

    @Schema(description = "文章分类")
    private String category;

    @Schema(description = "关键词")
    private String keyword;

    @DecimalMin(value = "1")
    @Schema(description = "页数")
    private Integer page;
}