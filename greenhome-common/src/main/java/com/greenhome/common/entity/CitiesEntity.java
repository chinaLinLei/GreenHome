package com.greenhome.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


@ApiModel(description = "城市实体类")
public class CitiesEntity implements Serializable {
    @ApiModelProperty(value = "城市ID:对应城市的前4位")
    private String cityId;

    @ApiModelProperty(value = "城市名称")
    private String city;

    @ApiModelProperty(value = "省份ID:对应身份证号码前两位")
    private String provinceId;

    @ApiModelProperty(value = "经办")
    private String agency;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "经办日期")
    private Date agencyDate;

    @ApiModelProperty(value = "状态：0:待生效/1:已生效/9:已失效/90:失效待确认")
    private String states;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency == null ? null : agency.trim();
    }

    public Date getAgencyDate() {
        return agencyDate;
    }

    public void setAgencyDate(Date agencyDate) {
        this.agencyDate = agencyDate;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states == null ? null : states.trim();
    }
}