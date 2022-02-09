package com.greenhome.common.constant;

import io.netty.util.internal.StringUtil;

import java.util.Map;

/**
 * @Author smart_joker
 * @Date 2022/2/9 1:50 下午
 * @Description 环境变量信息（单例模式）
 * @Version 1.0
 */
public class EnvInfo {
    //网卡名称
    public static String NETWORK_NAME;

    static {
        Map map = System.getenv();
        NETWORK_NAME = (String) map.get(Constant.DefaultKey.KEY_NETWORK_NAME);
        if (StringUtil.isNullOrEmpty(NETWORK_NAME)) {
            NETWORK_NAME = Constant.DefaultValue.NETWORK_NAME;
        }
    }


}
