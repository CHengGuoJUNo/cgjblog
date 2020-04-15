package com.blog.domain;

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
public class User {

    private Long id;

    private String name;

    private String email;

}
