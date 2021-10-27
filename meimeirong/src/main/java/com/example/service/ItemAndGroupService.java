package com.example.service;

import com.example.entity.ItemAndGroup;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ItemAndGroupMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemAndGroupService extends ServiceImpl<ItemAndGroupMapper, ItemAndGroup> {

    @Resource
    private ItemAndGroupMapper itemAndGroupMapper;

}