package com.greenhome.manage.controller;

import cn.hutool.http.HttpStatus;
import com.google.gson.Gson;
import com.greenhome.common.base.DefinitionException;
import com.greenhome.common.base.Result;
import com.greenhome.common.constant.GreenHomeEnum;
import com.mchange.v1.io.InputStreamUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


/**
 * @Author smart_joker
 * @Date 2022/2/15 2:22 下午
 * @Description ElasticSearch 测试类
 * @Version 1.0
 */

@RestController
@RequestMapping("/api/es")
@Api(tags = "ElasticSearch测试接口")
public class ESController {

    @Autowired
    private RestClient restClient;

    @ApiOperation(value = "设置Elastic的key-value值", notes = "key和value都是字符串类型，仅测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "value", value = "值", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Result addEs(String id, String value) throws IOException {
        Request request = new Request("PUT", "/city/doc/"+id);
        request.setJsonEntity(value);
        Response response = restClient.performRequest(request);
        System.out.println(response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode() == HttpStatus.HTTP_CREATED || response.getStatusLine().getStatusCode() == HttpStatus.HTTP_OK ){
            return  new Result();
        }else{
           throw new DefinitionException(GreenHomeEnum.ELASTICSEARCH_ERROR.getErrorCode(),response.getStatusLine().getReasonPhrase());
        }
    }

    @ApiOperation(value = "获取ES结果", notes = "仅测试")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getEs() throws IOException {
        Request request = new Request(
                "GET",
                "/city/_search");

        Response response = restClient.performRequest(request);
        if (response.getStatusLine().getStatusCode() == HttpStatus.HTTP_OK){
            return  new Result(new Gson().toJson(InputStreamUtils.getContentsAsString(response.getEntity().getContent()) ));
        }else{
            throw new DefinitionException(GreenHomeEnum.ELASTICSEARCH_ERROR.getErrorCode(),response.getStatusLine().getReasonPhrase());
        }
    }

}
