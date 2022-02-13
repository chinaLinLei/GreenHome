package com.greenhome.common.constant;

import java.io.Serializable;

/**
 * @Author smart_joker
 * @Date 2022/2/11 2:17 下午
 * @Description 状态值的数据字典
 * @Version 1.0
 */
public enum StatusEnum implements Serializable {

    PENDING("0", "待生效"),
    PASS("1", "生效"),
    EXPIRED("2", "已过期"),
    RESET("20", "重置"),
    LOCK("3", "锁定"),
    LOCK_PENDING("30", "解锁待确认"),
    SENDING("4", "发送中"),
    SEND_FAIL("5", "发送失败"),
    INVALID("9", "已失效"),
    INVALID_PENDING("90", "失效待确认"),
    START_UP("Y", "启用"),
    STOP("N", "未启用"),
    ;

    /** code值 */
    private String code;

    /** value值 */
    private String value;

    StatusEnum() {
    }

    StatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
