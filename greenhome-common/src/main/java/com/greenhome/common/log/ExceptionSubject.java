package com.greenhome.common.log;

import java.io.Serializable;

/**
 * @Author smart_joker
 * @Date 2022/2/10 6:06 下午
 * @Description 发生未捕获时的异常日志
 * @Version 1.0
 */
public class ExceptionSubject  implements Serializable {
    //请求的唯一标识
    private String sid;
    //操作描述
    private String description;
    //操作用户
    private String locationInfo;
    //操作时间
    private String time;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ExceptionSubject() {
    }

    public ExceptionSubject(String sid, String description, String locationInfo, String time) {
        this.sid = sid;
        this.description = description;
        this.locationInfo = locationInfo;
        this.time = time;
    }
}
