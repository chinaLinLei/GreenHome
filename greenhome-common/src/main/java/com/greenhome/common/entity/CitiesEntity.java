package com.greenhome.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.greenhome.common.annotation.EnumValid;
import com.greenhome.common.constant.StatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@ApiModel(description = "城市实体类")
public class CitiesEntity implements Serializable {

    @NotBlank(message = "城市ID不能为空")
    @Size(max=6, min=6, message = "城市ID长度必须等于6")
    @ApiModelProperty(value = "城市ID:对应城市的前4位", example = "323300")
    private String cityId;

    @NotBlank(message = "城市名称不能为空")
    @Size(max=50, min=1, message = "城市名称长度必须在1-50之间")
    @ApiModelProperty(value = "城市名称", example = "宿迁")
    private String city;

    @NotBlank(message = "省份ID不能为空")
    @Size(max=6, min=6, message = "省份ID长度必须等于6")
    @ApiModelProperty(value = "省份ID:对应身份证号码前两位", example = "320000")
    private String provinceId;

    @NotBlank(message = "经办人不能未空")
    @ApiModelProperty(value = "经办", example = "sys")
    private String agency;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "经办日期", example = "2021-11-21 10:55:11")
    private Date agencyDate;

    @NotBlank(message = "状态值不能未空")
    @EnumValid(target = StatusEnum.class, message = "状态值不存在")
    @ApiModelProperty(value = "状态：0:待生效/1:已生效/9:已失效/90:失效待确认", example = "0")
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