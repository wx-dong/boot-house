package com.etoak.mapper;

import com.etoak.bean.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by w on 2020/4/20.
 */
public interface AreaMapper {

    //根据父id查询子级列表
    List<Area> queryByPid(@Param("pid") int pid);

    //根据id查询地区
    Area queryById(@Param("id") int id);
}
