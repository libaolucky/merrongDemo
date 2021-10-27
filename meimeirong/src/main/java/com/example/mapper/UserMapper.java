package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;

// 在mybatis-plus 中，单表的增删改查，需要继承一个  BaseMapper<实体类名>
// 则， 该dao/Mapper 持久层  就有了  增删改查  的所有功能！，，， 很简洁，且功能强大，so 课下学
public interface UserMapper extends BaseMapper<User> {

    // 多表的  需要写 抽象方法！！

}
