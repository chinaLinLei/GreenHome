package com.greenhome.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greenhome.common.base.PageResult;
import com.greenhome.common.entity.CitiesEntity;
import com.greenhome.mapper.CitiesMapper;
import com.greenhome.service.inter.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author smart_joker
 * @Date 2022/1/28 3:00 下午
 * @Description 城市服务实现类
 * @Version 1.0
 */

@Service
public class CitiesServiceImpl  implements CitiesService {

    @Autowired
    private CitiesMapper citiesMapper;

    @Override
    public int deleteByPrimaryKey(String cityId) {
        return citiesMapper.deleteByPrimaryKey(cityId);
    }

    @Override
    public int insert(CitiesEntity record) {
        return citiesMapper.insert(record);
    }

    @Override
    public CitiesEntity selectByPrimaryKey(String cityId) {
        return citiesMapper.selectByPrimaryKey(cityId);
    }

    @Override
    public List<CitiesEntity> selectAll() {
        return citiesMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CitiesEntity record) {
        return citiesMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult<CitiesEntity> findAllUserByPages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CitiesEntity> lists = citiesMapper.selectAll();
        PageInfo<CitiesEntity> pageInfo = new PageInfo<CitiesEntity>(lists);
        return new PageResult<CitiesEntity>(pageInfo.getTotal(),pageInfo.getList());
    }
}
