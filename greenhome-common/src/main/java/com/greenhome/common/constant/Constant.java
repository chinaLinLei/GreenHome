package com.greenhome.common.constant;

import java.io.Serializable;

/**
 * @Author smart_joker
 * @Date 2022/2/9 1:46 下午
 * @Description 常量/数据字典
 * @Version 1.0
 */
public class Constant implements Serializable {

    /**
     * 默认的key（如：ip，port）
     */
    public static class DefaultKey {
        //ip地址的key值
        public final static String KEY_IP = "ip";
        //网卡key
        public final static String KEY_NETWORK_NAME= "GREENHOME_NETWORK_NAME";
        //操作系统的key
        public final static String KEY_OS_NAME= "os.name";
    }

    /**
     * 默认的value（如：ip，port，空的命名）
     */
    public static class DefaultValue {
        //网卡的名称
        public final static String NETWORK_NAME = "eth0";
        //客户访问无法获取的值，默认展示
        public final static String UNKNOWN = "Unknown";
        //默认IP地址
        public final static String IP = "127.0.0.1";
        //默认本地IPv6地址
        public final static String IPV6 = "0:0:0:0:0:0:0:1";
    }

    /**
     * 请求/响应头的key
     */
    public static class HeadersKey {
        //网关传递的唯一key
        public final static String KEY_SID = "x-sid";
        //请求用户信息
        public final static String HEADER_USER_AGENT = "user-agent";
        //获取源
        public final static String HEADER_ORIGIN = "Origin";
        //获取真实客户端IP地址
        public final static String HEADER_X_FORWARDED_FOR = "x-forwarded-for";
        public final static String HEADER_X_FORWARDED_FOR_UPPER = "X-Forwarded-For";
        public final static String HEADER_PROXY_IP = "Proxy-Client-IP";
        public final static String HEADER_WL_PROXY_IP = "WL-Proxy-Client-IP";
        public final static String HEADER_X_REAL_IP = "X-Real-IP";
    }


    /**
     * 操作系统的类型
     */
    public static class OsType {
        public final static String ANY = "Any";
        public final static String LINUX = "Linux";
        public final static String MAC_OS = "Mac OS";
        public final static String MAC_OS_X = "Mac OS X";
        public final static String WINDOWS = "Windows";
        public final static String OS2 = "OS/2";
        public final static String SOLARIS = "Solaris";
        public final static String SUNOS = "SunOS";
        public final static String MPEiX = "MPE/iX";
        public final static String HP_UX = "HP-UX";
        public final static String AIX = "AIX";
        public final static String OS390 = "OS/390";
        public final static String FREEBSD = "FreeBSD";
        public final static String IRIX = "Irix";
        public final static String DIGITAL_UNIX = "Digital Unix";
        public final static String NETWARE = "NetWare";
        public final static String OSF1 = "OSF1";
        public final static String OPENVMS = "OpenVMS";
        public final static String OTHERS = "Others";
    }

    /**
     * API加密类型的数据字典
     */
    public static class SignType {
        //sha256加密方式
        public final static String SHA256 = "SHA-256";
        //MD5加密方式
        public final static String MD5 = "MD5";
        //sm4，ecb方式
        public final static String SM4_ECB = "SM4/ECB/PKCS5Padding";
        public final static String SM4 = "SM4";
        //RSA
        public final static String RSA = "RSA";
        public final static String RSA_SHA1 = "SHA1WithRSA";
        public final static String SHA1 = "SHA-1";
        //utf-8值
        public final static String UTF8 = "UTF-8";
        //AES方式
        public final static String AES_CBC = "AES/CBC/PKCS5Padding";
        public final static String AES = "AES";

    }

    /**
     * API加密类型的数据字典
     */
    public static class ContentType {
        //json格式
        public final static String JSON = "application/json;charset=utf-8";
        //multipart
        public final static String MULTIPART = "multipart/form-data";
    }

    /**
     * 字符串格式化类型
     */
    public static class StringFormatType {
        public final static String LOG = "{}";
        public final static String ENUM_ERROR = "枚举对象{}缺少字段名为value的字段";
    }

    /**
     * 请求类型
     */
    public static class RequestType {
        //get请求
        public final static String GET = "GET";
        //POST请求
        public final static String POST = "POST";
    }

    /**
     *  http or https
     */
    public static class SchemeType {
        public static final String HTTP_SCHEME = "http";
        public static final String HTTPS_SCHEME = "https";
    }

}
