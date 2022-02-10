package com.greenhome.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * @Author smart_joker
 * @Date 2022/2/10 6:43 下午
 * @Description 分页返回结果集
 * @Version 1.0
 */
public class PageResult<T> implements Serializable {

    // 总页数
    private Long total;
    // 记录
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
