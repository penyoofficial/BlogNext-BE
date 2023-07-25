package com.penyo.penyoboot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.penyo.penyoboot.service.impl.userIdenceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:处理用户无关请求
 * @author: 顾壮壮
 * @date: 2023/7/24 16:50
 */
@Tag(name = "用户无关系接口")
@Controller
@RequiredArgsConstructor
public class userIdenceController {

    private final userIdenceServiceImpl userIdenceService;
    /**
     * 得到所有标语
     *
     * @return {@link String}
     */
    @Operation(summary = "得到所有标语")
    @ApiOperationSupport(order = 10)
    @ResponseBody
    @GetMapping("/getAllSlogans")
    public String getAllSlogans(){
        return userIdenceService.getAllSlogans();
    }

}
