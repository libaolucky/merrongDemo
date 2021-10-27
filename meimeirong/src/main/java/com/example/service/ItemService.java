package com.example.service;

import com.example.entity.Item;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemService extends ServiceImpl<ItemMapper, Item> {

    @Resource
    private ItemMapper itemMapper;

}