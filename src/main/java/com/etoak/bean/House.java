package com.etoak.bean;

import io.swagger.models.auth.In;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * Created by w on 2020/4/22.
 */
@Data
public class House {

    private Integer id;
    @NotNull(message = "省份必填")
    private Integer province;
    @NotNull(message = "市必填")
    private Integer city;
    @NotNull(message = "所在区必填")
    private Integer area;
    private String areaName;

    @NotNull(message = "租赁方式必填")
    @NotBlank(message = "租赁方式不能为空")
    private String rentMode;
    private String orientation;
    private String houseType;
    @NotNull(message = "租金必填")
    @Max(value = 100000,message = "租金不能超过十万")
    @Min(value = 100,message = "租金不能少于100")
    private Integer rental;
    @NotNull(message = "地址必填")
    @Size(min = 1,max = 10,message = "地址长度介于1~10个字符")
    private String address;
    private String pic;
    private String publishTime;

}
