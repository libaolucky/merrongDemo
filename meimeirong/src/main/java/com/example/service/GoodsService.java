package com.example.service;

import com.example.entity.Goods;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsService extends ServiceImpl<GoodsMapper, Goods> {

    @Resource
    private GoodsMapper goodsMapper;

}