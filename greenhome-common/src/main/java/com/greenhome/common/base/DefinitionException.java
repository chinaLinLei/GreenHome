package com.greenhome.common.base;

import com.greenhome.common.constant.GreenHomeEnum;

import java.io.Serializable;

/**
 * @Author smart_joker
 * @Date 2022/2/10 4:31 下午
 * @Description 自定义异常类
 * @Version 1.0
 */
public class DefinitionException extends RuntimeException implements Serializable {
    protected Integer errorCode;
    protected String errorMsg;

    public DefinitionException(){

    }
    public DefinitionException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public DefinitionException(GreenHomeEnum greenHomeEnum) {
        this.errorCode = greenHomeEnum.getErrorCode();
        this.errorMsg = greenHomeEnum.getErrorMsg();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
