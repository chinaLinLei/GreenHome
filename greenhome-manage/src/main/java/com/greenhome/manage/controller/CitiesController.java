package com.greenhome.manage.controller;

import com.github.pagehelper.PageInfo;
import com.greenhome.common.base.PageResult;
import com.greenhome.common.entity.CitiesEntity;
import com.greenhome.service.inter.CitiesService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author smart_joker
 * @Date 2022/1/27 2:32 下午
 * @Description 城市控制器
 * @Version 1.0
 */
@RestController
@Api(tags = "城市相关接口文档")
@RequestMapping("/city")
public class CitiesController {
    @Autowired
    public CitiesService citiesService;

    @ApiOperation(value="获取城市列表", notes="")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<CitiesEntity> select(){
        return citiesService.selectAll();
    }

    @ApiOperation(value="获取单个城市", notes="")
    @ApiImplicitParam(name = "id", value = "城市ID主键", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CitiesEntity selectCity(@PathVariable(required = true) String id){
        int a=0;
        int b = 1/a;
        return citiesService.selectByPrimaryKey(id);
    }

    @ApiOperation(value="新增城市信息", notes="无")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public  int addCity(@RequestBody CitiesEntity entity){
        return citiesService.insert(entity);
    }

    @ApiOperation(value="分页显示城市信息", notes="pageNum，从1开始（0是等于一的结果）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/query")
    public PageResult<CitiesEntity> findAllUserByPages(int pageNum, int pageSize){
        return citiesService.findAllUserByPages(pageNum,pageSize);
    }


}
