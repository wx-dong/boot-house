package com.etoak.service;

import com.etoak.bean.Dict;


import java.util.List;

/**
 * Created by w on 2020/4/21.
 */
public interface DictService {
    List<Dict> queryList(String groupId);

}
