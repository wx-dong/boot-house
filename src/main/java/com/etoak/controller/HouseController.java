package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 19161 on 2020/4/21.
 */
@Controller
@RequestMapping("/house")
public class HouseController {
    @RequestMapping("/toAdd")
    public String add(){
        return "house/add";
    }
}
