package com.penyo.penyoboot.model.query;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @description:
 * @author: 顾壮壮
 * @date: 2023/7/27 9:17
 */

public class SpringDataPageable implements Serializable, Pageable {
    private static final long serialVersionUID = 1;
    // 当前页
    private Integer pagenumber = 1;
    // 当前页面条数
    private Integer pagesize = 10;
    // 排序条件
    private Sort sort;

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    @Override
    public int getPageNumber() {
        return this.pagenumber;
    }

    @Override
    public int getPageSize() {
        return this.pagesize;
    }

    @Override
    public long getOffset() {
        return (getPagenumber() - 1) * getPageSize();
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}

