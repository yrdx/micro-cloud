package com.yrdx.common.result;

import java.util.List;

import lombok.Data;

/**
 * 封装分页结果返回
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 11:15
 */
@Data
public class PageResult<T> {

    private long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
