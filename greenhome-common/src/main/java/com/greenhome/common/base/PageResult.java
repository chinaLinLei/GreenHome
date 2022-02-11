package com.greenhome.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author smart_joker
 * @Date 2022/2/10 6:43 下午
 * @Description 分页返回结果集
 * @Version 1.0
 */

@ApiModel(description = "分页结果集")
public class PageResult<T> implements Serializable {

    @ApiModelProperty(value = "总页数")
    private Long total;

    @ApiModelProperty(value = "结果记录")
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
