package com.greenhome.mapper;


import com.greenhome.common.entity.CitiesEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CitiesMapper {
    int deleteByPrimaryKey(String cityId);

    int insert(CitiesEntity record);

    CitiesEntity selectByPrimaryKey(String cityId);

    List<CitiesEntity> selectAll();

    int updateByPrimaryKey(CitiesEntity record);
}