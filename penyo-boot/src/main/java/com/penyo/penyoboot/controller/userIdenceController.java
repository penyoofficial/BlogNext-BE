package com.penyo.penyoboot.controller;

import cn.hutool.json.JSONUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.penyo.penyoboot.common.result.Result;
import com.penyo.penyoboot.model.form.ArticlesForm;
import com.penyo.penyoboot.service.impl.userIdenceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

/**
 * @description:处理用户无关请求
 * @author: 顾壮壮
 * @date: 2023/7/24 16:50
 */
@Tag(name = "用户无关系接口")
@RestController
@RequiredArgsConstructor
public class userIdenceController {

    private final userIdenceServiceImpl userIdenceService;

    /**
     * 得到所有标语
     *
     * @return {@link String}
     */
    @Operation(summary = "得到所有标语")
    @ApiOperationSupport(order = 1)
    @GetMapping("/getAllSlogans")
    public Result<String> getAllSlogans(){
        return Result.success(userIdenceService.getAllSlogans()) ;
    }

    /**
     * 获取符合条件的文章信息
     *
     * @param articlesForm 文章表单
     * @return {@link Result}
     */
    @Operation(summary = "获取文章")
    @ApiOperationSupport(order = 2)
    @GetMapping("/getArtByIo")
    public Result<String> getArticleByInfo(
            @Parameter(description = "文章表单") ArticlesForm articlesForm
            ){
         return Result.success(JSONUtil.toJsonStr(userIdenceService.selectArticle(articlesForm)));
    }
}
