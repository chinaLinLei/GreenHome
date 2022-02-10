package com.greenhome.common.log;

/**
 * @Author smart_joker
 * @Date 2022/2/8 4:51 下午
 * @Description 全局日志记录
 * @Version 1.0
 */
public class LogSubject {
    //请求的唯一标识
    private String sid;
    //操作描述
    private String description;
    //操作用户
    private String username;
    //操作时间
    private String startTime;
    //消耗时间
    private String spendTime;
    //URL
    private String url;
    //请求类型
    private String method;
    //IP地址
    private String ip;
    //请求参数
    private Object parameter;
    //请求返回的结果
    private Object result;
    //城市
    private String city;
    //请求设备信息
    private String device;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public LogSubject() {
    }

    public LogSubject(String sid, String description, String username, String startTime, String spendTime, String url, String method, String ip, Object parameter, Object result, String city, String device) {
        this.sid = sid;
        this.description = description;
        this.username = username;
        this.startTime = startTime;
        this.spendTime = spendTime;
        this.url = url;
        this.method = method;
        this.ip = ip;
        this.parameter = parameter;
        this.result = result;
        this.city = city;
        this.device = device;
    }
}
