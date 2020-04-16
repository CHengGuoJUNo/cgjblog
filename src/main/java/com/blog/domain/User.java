package com.blog.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @program: 企业级博客
* @description: 用户实体类
* @author: 大橙子
* @Data:2020/4/12_16:10
**/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class User {
    @ApiModelProperty(value = "用户id" )
    private Long id;
    @ApiModelProperty(value = "用户姓名" )
    private String name;
    @ApiModelProperty(value = "用户邮箱" )
    private String email;

}
