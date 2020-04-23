package com.etoak.controller;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;
import com.etoak.exception.ParamException;
import com.etoak.service.HouseService;
import com.etoak.utils.ValidationUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by 19161 on 2020/4/21.
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    @Value("${upload.dir}")
    private String uploadDirectory;

    @Value("${upload.savePathPrefix}")
    private String savePathPrefix;

    @Autowired
    HouseService houseService;

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "house/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam("file")MultipartFile file,House house) throws IOException {
        ValidationUtil.validate(house);

        //上传文件
        String originalFilename = file.getOriginalFilename();
        //String suffix = FilenameUtils.getExtension(originalFilename);
        String prefix = UUID.randomUUID().toString().replaceAll("-","");
        String newFilename = prefix + "_" + originalFilename;

        File destFile = new File(this.uploadDirectory,newFilename);
        file.transferTo(destFile);

        house.setPic(this.savePathPrefix + newFilename);
        houseService.addHouse(house);

        return "redirect:/house/toAdd";
    }

    @PostMapping("/add2")
    public String add2(@RequestParam("file")MultipartFile file, @Valid House house, BindingResult bindingResult) throws IOException {
        //对参数进行校验
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(CollectionUtils.isNotEmpty(allErrors)){
            StringBuffer msgBuffer = new StringBuffer();
            for(ObjectError objectError : allErrors){
                String message = objectError.getDefaultMessage();
                msgBuffer.append(message).append(";");
            }
            throw  new ParamException("参数效验失败:" + msgBuffer.toString());
        }

        //上传文件
        String originalFilename = file.getOriginalFilename();
        //String suffix = FilenameUtils.getExtension(originalFilename);
        String prefix = UUID.randomUUID().toString().replaceAll("-","");
        String newFilename = prefix + "_" + originalFilename;

        File destFile = new File(this.uploadDirectory,newFilename);
        file.transferTo(destFile);

        house.setPic(this.savePathPrefix + newFilename);
        houseService.addHouse(house);

        return "redirect:/house/toAdd";
    }

    @GetMapping(value = "/list",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Page<HouseVo> queryList(
            @RequestParam(required = false,defaultValue = "1") int pageNum,
            @RequestParam(required = false,defaultValue = "10") int pageSize,
            HouseVo houseVo,
            @RequestParam(value = "rentalList[]",required = false) String[] rentalList){
        return houseService.queryList(pageNum,pageSize,houseVo,rentalList);
    }

    @GetMapping("/toList")
    public String toList(){
        return "house/list";
    }



}
