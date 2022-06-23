package com.greenhome.manage.config;

import com.greenhome.common.constant.Constant;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author smart_joker
 * @Date 2022/2/15 2:08 下午
 * @Description 配置Rest Client和Rest High Level Client
 * @Version 1.0
 */

@Configuration
public class ElasticsearchRestClient {

    private static final int ADDRESS_LENGTH = 2;

    /**
     * 使用冒号隔开ip和端口1
     */
    @Value("${elasticsearch.ip}")
    String[] ipAddress;

    @Bean
    public RestClient restClientBuilder() {
        HttpHost[] hosts = Arrays.stream(ipAddress)
                .map(this::makeHttpHost)
                .filter(Objects::nonNull)
                .toArray(HttpHost[]::new);
        return RestClient.builder(hosts).build();
    }


    private HttpHost makeHttpHost(String s) {
        assert StringUtils.isNotEmpty(s);
        String[] address = s.split(":");
        if (address.length == ADDRESS_LENGTH) {
            String ip = address[0];
            int port = Integer.parseInt(address[1]);
            return new HttpHost(ip, port, Constant.SchemeType.HTTP_SCHEME);
        } else {
            return null;
        }
    }
}
