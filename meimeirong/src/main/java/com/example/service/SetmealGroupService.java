package com.example.service;

import com.example.entity.SetmealGroup;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.SetmealGroupMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SetmealGroupService extends ServiceImpl<SetmealGroupMapper, SetmealGroup> {

    @Resource
    private SetmealGroupMapper setmealGroupMapper;

}