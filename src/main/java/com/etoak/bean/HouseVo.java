package com.etoak.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by w on 2020/4/22.
 */
@Data
public class HouseVo extends House {

    private String rentModeName;
    private String houseTypeName;
    private String orientationName;

    //接收前端的户型参数
    @JsonIgnore//不把这个字段封装到返回结果json中
    private String[] houseTypeList;

    //接收前端的朝向参数
    @JsonIgnore
    private List<String> orientationList;

    List<Map<String,Integer>> rentalMapList;

}
