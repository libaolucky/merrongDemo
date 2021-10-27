package com.example.service;

import com.example.entity.ItemAndGroup;
import com.example.entity.ItemGroup;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ItemAndGroupMapper;
import com.example.mapper.ItemGroupMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class ItemGroupService extends ServiceImpl<ItemGroupMapper, ItemGroup> {

    @Resource
    private ItemGroupMapper itemGroupMapper;

    @Resource
    private ItemAndGroupMapper itemAndGroupMapper;

    // 添加  组的对象和  中间表
    @Transactional  // 事务注解， 因为 一个方法操作多个表，可能 一个表操作成功了，另外一张表 没有 操作成功
    public Boolean adItemGroupAndTable(ItemGroup itemGroup, String[] newids) {
        // 2个步骤，  1.添加 itemGroup 这个表  2. 循环遍历  split  依次添加  中间表
        int i = itemGroupMapper.insert(itemGroup);
        log.info("保存了"+i+"条信息");

        Long groupId = itemGroup.getId();
      // int i=9/0;  逻辑： 因为 有一个中间表， 所以 要添加 要 操作 2张表！！！
        int x=0;
        for (String newid : newids) {
            long itemId = Long.parseLong(newid);
            ItemAndGroup itemAndGroup=new ItemAndGroup();
            itemAndGroup.setItemId(itemId);
            itemAndGroup.setGroupId(groupId);
            int y=itemAndGroupMapper.insert(itemAndGroup);  //1
            x=x+y;
        }
        log.info("newids的长度是"+newids.length);
        log.info("保存了"+x+"条信息");

        // 当 m 的数值 等于 newids 长度， 以及 i=1 的时候， 才是两张表插入成功。。 返回 增加成功
        if(i==1&&newids.length==x){
            log.info("添加成功！");
            return true;
        }else{
            log.info("添加失败！");
            return false;
        }

    }
}