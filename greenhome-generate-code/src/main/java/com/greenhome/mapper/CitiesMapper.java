package com.greenhome.mapper;

import com.greenhome.common.entity.CitiesEntity;
import java.util.List;

public interface CitiesMapper {
    int deleteByPrimaryKey(String cityId);

    int insert(CitiesEntity record);

    CitiesEntity selectByPrimaryKey(String cityId);

    List<CitiesEntity> selectAll();

    int updateByPrimaryKey(CitiesEntity record);
}