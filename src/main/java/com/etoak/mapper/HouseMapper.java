package com.etoak.mapper;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;

import java.util.List;

/**
 * Created by w on 2020/4/22.
 */
public interface HouseMapper {

    //添加房源信息
    int addHouse(House house);

    //房源列表查询
    List<HouseVo> queryList(HouseVo houseVo);



}
