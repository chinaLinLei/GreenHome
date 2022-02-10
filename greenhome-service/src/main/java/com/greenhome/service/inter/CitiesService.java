package com.greenhome.service.inter;

import com.greenhome.common.base.PageResult;
import com.greenhome.common.entity.CitiesEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author smart_joker
 * @Date 2022/1/28 2:58 下午
 * @Description 城市服务
 * @Version 1.0
 */

@Transactional
public interface CitiesService {
    int deleteByPrimaryKey(String cityId);

    int insert(CitiesEntity record);

    CitiesEntity selectByPrimaryKey(String cityId);

    List<CitiesEntity> selectAll();

    int updateByPrimaryKey(CitiesEntity record);

    PageResult<CitiesEntity> findAllUserByPages(int pageNum, int pageSize);
}
