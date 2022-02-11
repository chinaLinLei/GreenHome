package com.greenhome.common.base;

import com.greenhome.common.constant.GreenHomeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author smart_joker
 * @Date 2022/2/10 4:17 下午
 * @Description 通用返回结果信息
 * @Version 1.0
 */

@ApiModel(description = "通用返回结果类")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "请求唯一标识")
    private String sid;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "提示信息")
    private String msg;

    @ApiModelProperty(value = "数据")
    private T data;

    public Result() {
        this.code = GreenHomeEnum.SUCCESS.getErrorCode();
        this.msg = GreenHomeEnum.SUCCESS.getErrorMsg();
    }

    public Result(T data) {
        this();
        this.data = data;
    }

    /**
     *  自定义返回结果的构造方法
     * @param code 状态码
     * @param msg 提示信息
     * @param data 数据
     */
    public Result(Integer code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 自定义异常返回的结果
     * @param de 自定义的异常
     * @return
     */
    public static Result defineError(DefinitionException de){
        Result result = new Result();
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }

    /**
     * 自定义异常返回的结果
     * @param code 状态码
     * @param msg 提示信息
     * @return
     */
    public static Result defineError(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 其他异常处理方法返回的结果
     * @param greenHomeEnum 状态码数据字典
     * @return
     */
    public static Result otherError(GreenHomeEnum greenHomeEnum){
        Result result = new Result();
        result.setMsg(greenHomeEnum.getErrorMsg());
        result.setCode(greenHomeEnum.getErrorCode());
        result.setData(null);
        return result;
    }



    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
