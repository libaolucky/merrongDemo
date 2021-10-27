package com.example.service;

import com.example.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.SetmealMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SetmealService extends ServiceImpl<SetmealMapper, Setmeal> {

    @Resource
    private SetmealMapper setmealMapper;

}