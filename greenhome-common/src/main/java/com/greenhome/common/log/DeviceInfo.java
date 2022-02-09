package com.greenhome.common.log;

/**
 * @Author smart_joker
 * @Date 2022/2/8 5:48 下午
 * @Description 设备信息
 * @Version 1.0
 */
public class DeviceInfo {

    //客户端类型  手机、电脑、平板
    private String clientType;
    //操作系统类型
    private String os;
    //浏览器类型
    private String browser;

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public DeviceInfo() {
    }

    public DeviceInfo(String clientType, String os, String browser) {
        this.clientType = clientType;
        this.os = os;
        this.browser = browser;
    }
}
