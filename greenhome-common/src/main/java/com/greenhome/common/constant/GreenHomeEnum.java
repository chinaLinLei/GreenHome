package com.greenhome.common.constant;

import java.io.Serializable;

/**
 * @Author smart_joker
 * @Date 2022/2/10 4:24 下午
 * @Description 状态码
 * @Version 1.0
 */
public enum GreenHomeEnum implements Serializable {
    SUCCESS(200, "操作成功!!!"),
    NO_PERMISSION(403,"无权限执行该操作!!!"),
    NO_AUTH(401,"登陆失效，请重新登陆!!!"),
    NOT_FOUND(404, "未找到该资源!!!"),
    INTERNAL_SERVER_ERROR(500, "服务器异常!!!"),
    ILLEGAL_STATE_ERROR(202020, "无法解析目标方法!!!"),

    ;

    /** 错误码 */
    private Integer errorCode;

    /** 错误信息 */
    private String errorMsg;

    GreenHomeEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
